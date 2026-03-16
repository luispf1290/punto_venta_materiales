package com.nohadev.puntoventa.catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ProductoResponse {
    private  String codigo_barras;
    private  String sku;
    private String descripcion;
    private Double costo_promedio;
    private Double precio_venta;
    private Double stock_minimo;
    private Boolean activo;
}
