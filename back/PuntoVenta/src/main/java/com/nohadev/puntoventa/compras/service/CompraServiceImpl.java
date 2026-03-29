package com.nohadev.puntoventa.compras.service;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import com.nohadev.puntoventa.compras.dto.CompraRequest;
import com.nohadev.puntoventa.compras.dto.CompraResponse;
import com.nohadev.puntoventa.compras.dto.DetalleCompraDTO;
import com.nohadev.puntoventa.compras.entity.Compra;
import com.nohadev.puntoventa.compras.entity.DetalleCompra;
import com.nohadev.puntoventa.compras.entity.Provedor;
import com.nohadev.puntoventa.compras.mapper.CompraMapper;
import com.nohadev.puntoventa.compras.repository.CompraRepository;
import com.nohadev.puntoventa.compras.repository.DetalleCompraRepository;
import com.nohadev.puntoventa.compras.repository.ProvedorRepository;
import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioRequest;
import com.nohadev.puntoventa.inventario.service.MovimientoInventarioService;
import com.nohadev.puntoventa.shared.Enums.TipoMovimiento;
import com.nohadev.puntoventa.shared.Enums.TipoOperacion;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;
    private final DetalleCompraRepository detalleCompraRepository;
    private final ProvedorRepository provedorRepository;
    private final CompraMapper compraMapper;
    private final MovimientoInventarioService movimientoInventarioService;

    @Override
    public CompraResponse crearCompra(CompraRequest compraRequest) {

        //TODO: Implentar generacion el folio de la compra
        Compra compra = new Compra();
        compra.setFecha(compraRequest.getFecha());
        compra.setEstatus("COMPRADA");

        BigDecimal subtotal = BigDecimal.ZERO;
        BigDecimal importe = BigDecimal.ZERO;

        for (DetalleCompraDTO d : compraRequest.getDetalles()) {
            importe = d.getCantidad().multiply(d.getCosto_unitario());
            d.setImporte(importe);
            subtotal = subtotal.add(d.getImporte());
        }

        Provedor provedor = provedorRepository.findById(compraRequest.getProvedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        BigDecimal iva = subtotal.multiply(new BigDecimal("0.16"));
        compra.setSubtotal(subtotal);
        compra.setIva(iva);
        compra.setTotal(subtotal.add(iva));
        compra.setProveedor(provedor);

        Compra compraSave = compraRepository.save(compra);


        for(DetalleCompraDTO d: compraRequest.getDetalles()){
            DetalleCompra detalleCompra = new DetalleCompra();
            detalleCompra.setCompra(compraSave);
            detalleCompra.setCantidad(d.getCantidad());
            detalleCompra.setCosto_unitario(d.getCosto_unitario());
            detalleCompra.setImporte(d.getImporte());
            detalleCompra.setProducto(d.getProducto());

            detalleCompraRepository.save(detalleCompra);

            MovimientoInventarioRequest movRequest = new MovimientoInventarioRequest();

            movRequest.setProductoId(d.getProductoId());
            movRequest.setCantidad(d.getCantidad());
            movRequest.setTipo_movimiento(TipoMovimiento.ENTRADA);
            movRequest.setTipo_operacion(TipoOperacion.COMPRA);
            movRequest.setTipo_documento("Compra ID: " + compraSave.getId());
            movRequest.setCosto_unitario(d.getCosto_unitario());
            movRequest.setUsuarioId(d.getUsuarioId());
            movRequest.setAlmacenId(d.getAlmacenId());

            movimientoInventarioService.procesarMovimientoInventario(movRequest);
        }

        return compraMapper.toDTO(compraSave);
    }

    @Override
    public CompraResponse obtenerCompraPorId(Long id) {
        Compra compra = compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));

        return compraMapper.toDTO(compra);
    }

    @Override
    public List<CompraResponse> obtenerTodasLasCompras() {
        return compraRepository.findAll().stream()
                .map(compraMapper::toDTO)
                .toList();
    }
}
