package com.nohadev.puntoventa.inventario.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Getter
@Setter
public class AlmacenResponse {
    private Long id;
    private String nombre;
    private String ubicacion;
}
