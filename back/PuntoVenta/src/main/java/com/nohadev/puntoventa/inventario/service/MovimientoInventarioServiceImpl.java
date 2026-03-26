package com.nohadev.puntoventa.inventario.service;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import com.nohadev.puntoventa.catalogo.repository.ProductoRepository;
import com.nohadev.puntoventa.core.security.repository.UsuarioRepository;
import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioRequest;
import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioResponse;
import com.nohadev.puntoventa.inventario.entity.MovimientosInventario;
import com.nohadev.puntoventa.inventario.mapper.MoviminetoInventarioMapper;
import com.nohadev.puntoventa.inventario.repository.AlmacenRepository;
import com.nohadev.puntoventa.inventario.repository.InventarioRepository;
import com.nohadev.puntoventa.inventario.repository.MovimientoInventarioRepository;
import com.nohadev.puntoventa.shared.Enums.TipoMovimiento;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MovimientoInventarioServiceImpl implements  MovimientoInventarioService{

    private final MovimientoInventarioRepository movimientoInventarioRepository;
    private  final InventarioRepository inventarioRepository;
    private final ProductoRepository productoRepository;
    private final AlmacenRepository almacenRepository;
    private final UsuarioRepository usuarioRepository;
    private final MoviminetoInventarioMapper moviminetoInventarioMapper;


    @Override
    public List<MovimientoInventarioResponse> obtenerKardexProducto(Long productoId) {
        return movimientoInventarioRepository.findByProductoIdOrderByFechaDesc(productoId)
                .stream()
                .map(moviminetoInventarioMapper::toDTO)
                .toList();
    }

    @Override
    public void procesarMovimientoInventario(MovimientoInventarioRequest request) {
        Producto producto = productoRepository.findById(request.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        BigDecimal nuevoStock = getBigDecimal(request, producto);

        // 5. Recalcular Costo Promedio Ponderado (Solo en entradas/compras)
        if(request.getTipo_movimiento() == TipoMovimiento.ENTRADA && request.getCosto_unitario() != null) {
           recalcularCostoPromedio(producto, request.getCantidad(), request.getCosto_unitario());
        }

        producto.setStock_actual(nuevoStock);
        productoRepository.save(producto);
        // 7. Registrar Movimiento (La "foto" del momento)

        MovimientosInventario movimiento = MovimientosInventario.builder()
                .tipo_movimiento(request.getTipo_movimiento())
                .tipo_documento(request.getTipo_documento())
                .cantidad(request.getCantidad())
                .costo_unitario(request.getCosto_unitario())
                .existenciaAnterior(producto.getStock_actual())
                .existenciaNueva(nuevoStock)
                .fecha(LocalDate.now())
                .producto(productoRepository.getReferenceById(request.getProductoId()))
                .almacen(almacenRepository.getReferenceById(request.getAlmacenId()))
                .usuario(usuarioRepository.getReferenceById(request.getUsuarioId()))
                .build();

        movimientoInventarioRepository.save(movimiento);

        //return moviminetoInventarioMapper.toDTO(movimiento);
    }

    private static @NonNull BigDecimal getBigDecimal(MovimientoInventarioRequest request, Producto producto) {
        BigDecimal stockAnterior = producto.getStock_actual();

        // 3. Calcular nuevo stock según el tipo (ENTRADA / SALIDA)
        BigDecimal nuevoStock = (request.getTipo_movimiento() == TipoMovimiento.ENTRADA)
                ? stockAnterior.add(request.getCantidad())
                : stockAnterior.subtract(request.getCantidad());

        // 4. Regla de negocio: No permitir stock negativo si es salida
        if(nuevoStock.compareTo(BigDecimal.ZERO) < 0){
            throw  new RuntimeException("No se puede procesar movimiento. Stock insuficiente para salida del producto:" + producto.getNombre());

        }
        return nuevoStock;
    }

    private void recalcularCostoPromedio(Producto producto, BigDecimal cantNueva, BigDecimal costoNuevo){
        BigDecimal stockActual = producto.getStock_actual();
        BigDecimal costoActual = producto.getCosto_promedio();
        BigDecimal valorTotalActual = stockActual.multiply(costoActual);
        BigDecimal valorNuevaEntrada = cantNueva.multiply(costoNuevo);
        BigDecimal stockTotalNuevo = stockActual.add(cantNueva);

        BigDecimal nuevoCostoPromedio = valorTotalActual.add(valorNuevaEntrada)
                .divide(stockTotalNuevo, 4, RoundingMode.HALF_UP);

        producto.setCosto_promedio(nuevoCostoPromedio);
        productoRepository.save(producto);
    }
}
