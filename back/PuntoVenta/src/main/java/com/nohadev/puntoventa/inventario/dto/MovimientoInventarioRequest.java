package com.nohadev.puntoventa.inventario.dto;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import com.nohadev.puntoventa.core.security.entity.Usuario;
import com.nohadev.puntoventa.inventario.entity.Almacen;
import com.nohadev.puntoventa.shared.Enums.TipoMovimiento;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class MovimientoInventarioRequest {
    private TipoMovimiento tipo_movimiento;
    private String tipo_documento;
    private Long id_documento;
    private BigDecimal cantidad;
    /*private BigDecimal existenciaAnterior;
    private BigDecimal existenciaNueva;*/
    private BigDecimal costo_unitario;
    private LocalDate fecha;
    private Long productoId;
    private Long almacenId;
    private Long usuarioId;
}
