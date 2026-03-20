package com.nohadev.puntoventa.inventario.dto;

import com.nohadev.puntoventa.shared.Enums.TipoMovimiento;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class MovimientoInventarioResponse {
    private Long id;
    private TipoMovimiento tipo_movimiento;
    private String tipo_documento;
    private Long id_documento;
    private BigDecimal cantidad;
    private BigDecimal existenciaAnterior;
    private BigDecimal existenciaNueva;
    private BigDecimal costo_unitario;
    private LocalDate fecha;
    private String nombreProducto;
    private String nombreAlmacen;
    private String nombreUsuario;
}
