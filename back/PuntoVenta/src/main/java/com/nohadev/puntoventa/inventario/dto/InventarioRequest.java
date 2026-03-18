package com.nohadev.puntoventa.inventario.dto;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class InventarioRequest {
    private BigDecimal exitencia_actual;
    private Long productoId;
    private Long almacenId;
}
