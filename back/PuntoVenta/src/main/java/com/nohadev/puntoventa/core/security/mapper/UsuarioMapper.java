package com.nohadev.puntoventa.core.security.mapper;

import com.nohadev.puntoventa.core.security.dto.UsuarioRequestDTO;
import com.nohadev.puntoventa.core.security.dto.UsuarioResponseDTO;
import com.nohadev.puntoventa.core.security.entity.Usuario;
import com.nohadev.puntoventa.core.security.entity.UsuarioRol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "roles", source = "usuario.usuarioRoles")

    UsuarioResponseDTO toDTO(Usuario usuario);
    Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO);

    default List<String> mapRoles(Set<UsuarioRol> usuarioRoles){
        if (usuarioRoles == null) {
            return List.of();
        }
        return usuarioRoles.stream()
                .map(ur -> ur.getRol().getNombre())
                .toList();
    }
}
