package com.nohadev.puntoventa.catalogo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MarcaResponse {
    private Long id;
    private String nombre;
}
