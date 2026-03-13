package com.nohadev.puntoventa.core.security.mapper;

import com.nohadev.puntoventa.core.security.dto.UsuarioRequestDTO;
import com.nohadev.puntoventa.core.security.dto.UsuarioResponseDTO;
import com.nohadev.puntoventa.core.security.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioResponseDTO toDTO(Usuario usuario);
    Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO);
}
