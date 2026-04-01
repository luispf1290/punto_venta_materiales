package com.nohadev.puntoventa.catalogo.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoResponse {
    private Long id;
    private String nombre;
    private String codigo_barras;
    private String sku;

    private String descripcion;
    private BigDecimal costo_promedio;
    private BigDecimal precio_venta;
    private BigDecimal costo_unitario;
    private BigDecimal stock_actual;
    private BigDecimal stock_minimo;
    private Boolean activo;

    private String  categoriaNombre;
    private String marcaNombre;

    private List<ProductoUnidadResponse> unidades;
}
