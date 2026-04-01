package com.nohadev.puntoventa.catalogo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoUnidadRequest {
    private Long unidadMedidaId;
    private Long productoId;
    private BigDecimal factorConversion;
    private BigDecimal precioVenta;
}
