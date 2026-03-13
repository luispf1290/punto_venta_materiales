package com.nohadev.puntoventa.core.security.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String username;
    private List<String> roles;
}
