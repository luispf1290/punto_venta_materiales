package com.nohadev.puntoventa.ventas.service;

import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioRequest;
import com.nohadev.puntoventa.inventario.service.MovimientoInventarioService;
import com.nohadev.puntoventa.shared.Enums.TipoMovimiento;
import com.nohadev.puntoventa.shared.Enums.TipoOperacion;
import com.nohadev.puntoventa.ventas.dto.DetalleVentaDTO;
import com.nohadev.puntoventa.ventas.dto.VentaRequest;
import com.nohadev.puntoventa.ventas.dto.VentaResponse;
import com.nohadev.puntoventa.ventas.entity.DetalleVenta;
import com.nohadev.puntoventa.ventas.entity.Venta;
import com.nohadev.puntoventa.ventas.mapper.VentaMapper;
import com.nohadev.puntoventa.ventas.repository.DetalleVentaRepository;
import com.nohadev.puntoventa.ventas.repository.VentaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;
    private final VentaMapper ventaMapper;
    private final FolioService folioService;
    private final FacturaService facturaService;
    private final MovimientoInventarioService movimientoInventarioService;

    @Override
    public VentaResponse crearVenta(VentaRequest ventaRequest) {

        String folio = folioService.generarFolioVenta();
        Venta venta = new Venta();
        venta.setFolio(folio);
        venta.setFecha(ventaRequest.getFecha());
        venta.setMetodo_pago(ventaRequest.getMetodo_pago());
        venta.setEstatus("PAGADA");

        BigDecimal subtotal = BigDecimal.ZERO;

        for(DetalleVentaDTO d : ventaRequest.getDetalles()){
            subtotal = subtotal.add(d.getImporte());
        }

        BigDecimal iva = subtotal.multiply(new BigDecimal("0.16"));
        venta.setSubtotal(subtotal);
        venta.setIva(iva);
        venta.setTotal(subtotal.add(iva));

        Venta ventaSave = ventaRepository.save(venta);

        for(DetalleVentaDTO d : ventaRequest.getDetalles()){
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setVenta(ventaSave);
            detalleVenta.setCantidad(d.getCantidad());
            detalleVenta.setPrecio_unitario(d.getPrecioUnitario());
            detalleVenta.setDescuento(d.getDescuento());
            detalleVenta.setImporte(d.getImporte());

            detalleVentaRepository.save(detalleVenta);

            MovimientoInventarioRequest movRequest = new MovimientoInventarioRequest();
            movRequest.setProductoId(d.getProductoId());
            movRequest.setCantidad(d.getCantidad());
            movRequest.setTipo_movimiento(TipoMovimiento.SALIDA);
            movRequest.setTipo_operacion(TipoOperacion.VENTA);
            movRequest.setTipo_documento("Venta ID: " + ventaSave.getFolio());
            movRequest.setCosto_unitario(d.getPrecioUnitario());
            movRequest.setAlmacenId(d.getAlmacenId());
            movRequest.setUsuarioId(d.getUsuarioId());

            movimientoInventarioService.procesarMovimientoInventario(movRequest);
        }

        facturaService.crearFactura(ventaSave);

        return ventaMapper.toDTO(ventaSave);

    }

    @Override
    public VentaResponse obtenerVentaPorId(Long id) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        return ventaMapper.toDTO(venta);
    }

    @Override
    public List<VentaResponse> obtenerTodasLasVentas() {
        return ventaRepository.findAll().stream()
                .map(ventaMapper::toDTO)
                .toList();
    }
}
