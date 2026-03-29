package com.nohadev.puntoventa.compras.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProvedorRequest {
    private String nombre;
    private String rfc;
    private String telefono;
    private String email;
    private String direccion;
    private Boolean activo;
}
