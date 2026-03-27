package com.nohadev.puntoventa.compras.dto;

import com.nohadev.puntoventa.compras.entity.DetalleCompra;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
public class CompraRequest {
    private LocalDate fecha;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal total;
    private String estatus;
    private Long provedorId;
    private Long usuarioId;
    private List<DetalleCompraDTO> detalles;
}
