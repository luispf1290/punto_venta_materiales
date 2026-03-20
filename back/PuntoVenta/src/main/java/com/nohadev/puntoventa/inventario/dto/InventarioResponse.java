package com.nohadev.puntoventa.inventario.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class InventarioResponse {
    private Long id;
    private BigDecimal exitencia_actual;
    private String nombreProducto;
    private String nombreAlmacen;
}
