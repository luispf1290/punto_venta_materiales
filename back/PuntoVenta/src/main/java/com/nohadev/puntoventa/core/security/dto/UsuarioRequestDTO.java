package com.nohadev.puntoventa.core.security.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioRequestDTO {
    private String nombre;
    private String username;
    private String password;
    private List<Long> roles;

}
