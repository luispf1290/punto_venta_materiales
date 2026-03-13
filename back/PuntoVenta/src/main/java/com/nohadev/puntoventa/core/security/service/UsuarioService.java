package com.nohadev.puntoventa.core.security.service;

import com.nohadev.puntoventa.core.security.dto.UsuarioRequestDTO;
import com.nohadev.puntoventa.core.security.dto.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO usuarioRequestDTO);
    List<UsuarioResponseDTO> obtenerTodosLosUsuarios();
    UsuarioResponseDTO obtenerUsuarioPorId(Long id);
}
