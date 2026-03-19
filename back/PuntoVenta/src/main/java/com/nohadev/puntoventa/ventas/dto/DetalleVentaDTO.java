package com.nohadev.puntoventa.ventas.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class DetalleVentaDTO {
    private Long productoId;

    private Long productoUnidadId;

    private BigDecimal cantidad;

    private BigDecimal precioUnitario;

    private BigDecimal descuento;

    private BigDecimal importe;
}
