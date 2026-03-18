package com.nohadev.puntoventa.inventario.dto;

import com.nohadev.puntoventa.shared.Enums.TipoMovimiento;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
@RequiredArgsConstructor
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
    private String producto;
    private String almacen;
    private String usuario;
}
