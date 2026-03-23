package com.nohadev.puntoventa.inventario.dto;


import com.nohadev.puntoventa.shared.Enums.TipoMovimiento;
import com.nohadev.puntoventa.shared.Enums.TipoOperacion;
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
    private TipoOperacion tipo_operacion;
    private String tipo_documento;
    private Long id_documento;
    private BigDecimal cantidad;
    private BigDecimal existenciaAnterior;
    private BigDecimal existenciaNueva;
    private BigDecimal costo_unitario;
    private LocalDate fecha;
    private Long productoId;
    private Long almacenId;
    private Long usuarioId;
}
