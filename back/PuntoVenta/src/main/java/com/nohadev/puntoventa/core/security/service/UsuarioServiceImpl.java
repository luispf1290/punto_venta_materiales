package com.nohadev.puntoventa.core.security.service;

import com.nohadev.puntoventa.core.security.dto.UsuarioRequestDTO;
import com.nohadev.puntoventa.core.security.dto.UsuarioResponseDTO;
import com.nohadev.puntoventa.core.security.entity.Usuario;
import com.nohadev.puntoventa.core.security.entity.UsuarioRol;
import com.nohadev.puntoventa.core.security.mapper.UsuarioMapper;
import com.nohadev.puntoventa.core.security.repository.RolRepository;
import com.nohadev.puntoventa.core.security.repository.UsuarioRepository;
import com.nohadev.puntoventa.core.security.repository.UsuarioRolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioRolRepository usuarioRolRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO usuarioRequestDTO) {

        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioRequestDTO.getUsername());
        usuario.setPassword(usuarioRequestDTO.getPassword());
        usuario.setNombre(usuarioRequestDTO.getNombre());

        usuarioRepository.save(usuario);

        for (Long rolId : usuarioRequestDTO.getRoles()) {
            var rol = rolRepository.findById(rolId)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + rolId));

            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setUsuario(usuario);
            usuarioRol.setRol(rol);
            usuarioRolRepository.save(usuarioRol);
        }

        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDTO)
                .toList();
    }

    @Override
    public UsuarioResponseDTO obtenerUsuarioPorId(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        return usuarioMapper.toDTO(usuario);
    }
}
