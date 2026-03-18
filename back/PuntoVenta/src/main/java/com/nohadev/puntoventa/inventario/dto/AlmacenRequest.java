package com.nohadev.puntoventa.inventario.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class AlmacenRequest {
    private String nombre;
    private String ubicacion;
}
