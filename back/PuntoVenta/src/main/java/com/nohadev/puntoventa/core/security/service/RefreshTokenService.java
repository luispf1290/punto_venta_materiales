package com.nohadev.puntoventa.core.security.service;

import com.nohadev.puntoventa.core.security.entity.RefreshToken;
import com.nohadev.puntoventa.core.security.entity.Usuario;
import com.nohadev.puntoventa.core.security.repository.RefreshTokenRepository;
import com.nohadev.puntoventa.core.security.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final UsuarioRepository usuarioRepository;
    private final long REFRESH_EXPIRATION = 604800000;

    public RefreshToken createRefreshToken(String username){

        Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow();

        RefreshToken token = new RefreshToken();

        token.setUsuario(usuario);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Instant.now().plusMillis(REFRESH_EXPIRATION));

        return refreshTokenRepository.save(token);
    }
}
