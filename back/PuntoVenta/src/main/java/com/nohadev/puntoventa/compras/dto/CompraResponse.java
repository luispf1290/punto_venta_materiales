package com.nohadev.puntoventa.compras.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
public class CompraResponse {
    private Long id;
    private LocalDate fecha;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal total;
    private String estatus;
    private String nombreProvedor;
    private String nombreUsuario;
}
