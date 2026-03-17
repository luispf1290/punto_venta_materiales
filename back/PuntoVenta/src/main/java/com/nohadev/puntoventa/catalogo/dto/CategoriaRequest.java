package com.nohadev.puntoventa.catalogo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoriaRequest {
    private String nombre;
    private String descripcion;
    private Boolean activo;
}
