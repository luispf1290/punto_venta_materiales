package com.nohadev.puntoventa.ventas.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FacturaDTO {
    private Long id;

    private String uuid;

    private String serie;

    private String folio;

    private LocalDate fecha;
}
