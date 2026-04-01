package com.nohadev.puntoventa.catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoUnidadResponse {
    private Long id;
    private Long unidadMedidaId;
    private String unidadNombre;
    private String productoNombre;
    private BigDecimal factorConversion;
    private BigDecimal precioVenta;
}
