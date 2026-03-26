package com.nohadev.puntoventa.catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductoRequest {
   private  String codigo_barras;
   private  String sku;
   private String descripcion;
   private BigDecimal costo_promedio;
   private BigDecimal precio_venta;
   private BigDecimal stock_minimo;
   private Long categoriaId;
   private Long marcaId;
   private Boolean activo;
}
