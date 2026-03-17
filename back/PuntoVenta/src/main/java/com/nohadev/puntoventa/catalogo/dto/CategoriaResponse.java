package com.nohadev.puntoventa.catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoriaResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean activo = true;
}
