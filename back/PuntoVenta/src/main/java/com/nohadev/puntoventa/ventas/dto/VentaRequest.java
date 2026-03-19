package com.nohadev.puntoventa.ventas.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
public class VentaRequest {
    private  String folio;
    private LocalDate fecha;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal descuento;
    private BigDecimal total;
    private String metodo_pago;
    private String estatus;
    private Long clienteId;
    private Long usuarioId;
    private List<DetalleVentaDTO> detalles;
}
