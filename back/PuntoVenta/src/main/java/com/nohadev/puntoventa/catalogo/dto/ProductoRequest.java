package com.nohadev.puntoventa.catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoRequest {
   private  String codigo_barras;
   private  String sku;
   private String descripcion;
   private Double costo_promedio;
   private Double precio_venta;
   private Double stock_minimo;
   private Long categoriaId;
   private Long marcaId;
   private Boolean activo;
}
