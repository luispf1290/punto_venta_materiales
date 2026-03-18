package com.nohadev.puntoventa.inventario.service;

import com.nohadev.puntoventa.catalogo.repository.ProductoRepository;
import com.nohadev.puntoventa.core.security.repository.UsuarioRepository;
import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioRequest;
import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioResponse;
import com.nohadev.puntoventa.inventario.entity.Inventario;
import com.nohadev.puntoventa.inventario.entity.MovimientosInventario;
import com.nohadev.puntoventa.inventario.mapper.MoviminetoInventarioMapper;
import com.nohadev.puntoventa.inventario.repository.AlmacenRepository;
import com.nohadev.puntoventa.inventario.repository.InventarioRepository;
import com.nohadev.puntoventa.inventario.repository.MovimientoInventarioRepository;
import com.nohadev.puntoventa.shared.Enums.TipoMovimiento;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public MovimientoInventarioResponse registrarMovimientoInventario(MovimientoInventarioRequest request) {

        Inventario inventario = inventarioRepository.findByProductoIdAndAlmacenId(request.getProductoId(), request.getAlmacenId())
                .orElseThrow(()-> new RuntimeException("Inventario no encontrado para el producto y almacen especificados"));

        BigDecimal existenciaAnterior = inventario.getExitencia_actual();
        BigDecimal nuevaExistencia;

        if(request.getTipo_movimiento() == TipoMovimiento.ENTRADA){
          nuevaExistencia = existenciaAnterior.add(request.getCantidad());
        }else {
            nuevaExistencia = existenciaAnterior.subtract(request.getCantidad());
        }

        inventario.setExitencia_actual(nuevaExistencia);
        inventarioRepository.save(inventario);

        MovimientosInventario movimiento = MovimientosInventario.builder()
                .tipo_movimiento(request.getTipo_movimiento())
                .cantidad(request.getCantidad())
                .costo_unitario(request.getCosto_unitario())
                .existenciaAnterior(existenciaAnterior)
                .existenciaNueva(nuevaExistencia)
                .fecha(LocalDate.now())
                .producto(productoRepository.getReferenceById(request.getProductoId()))
                .almacen(almacenRepository.getReferenceById(request.getAlmacenId()))
                .usuario(usuarioRepository.getReferenceById(request.getUsuarioId()))
                .build();

        movimientoInventarioRepository.save(movimiento);

        return moviminetoInventarioMapper.toDTO(movimiento);
    }

    @Override
    public List<MovimientoInventarioResponse> obtenerKardexProducto(Long productoId) {
        return movimientoInventarioRepository.findByProductoIdOrderByFechaDesc(productoId)
                .stream()
                .map(moviminetoInventarioMapper::toDTO)
                .toList();
    }
}
