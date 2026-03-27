package com.nohadev.puntoventa.compras.dto;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class DetalleCompraDTO {
    private BigDecimal cantidad;
    private BigDecimal costo_unitario;
    private BigDecimal importe;
    private Long productoId;
    private Long compraId;
    private Long almacenId;
    private Long usuarioId;
    private Long producto_id;
    private Producto producto;
}
