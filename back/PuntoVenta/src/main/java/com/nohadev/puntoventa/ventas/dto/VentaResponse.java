package com.nohadev.puntoventa.ventas.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
public class VentaResponse {
    private Long id;
    private  String folio;
    private LocalDate fecha;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal descuento;
    private BigDecimal total;
    private String metodo_pago;
    private String estatus;
    private String nombreCliente;
    private String nombreUsuario;
}
