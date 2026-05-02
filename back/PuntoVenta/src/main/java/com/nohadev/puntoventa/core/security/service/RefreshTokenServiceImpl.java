package com.nohadev.puntoventa.core.security.service;

import com.nohadev.puntoventa.core.security.entity.RefreshToken;
import com.nohadev.puntoventa.core.security.entity.Usuario;
import com.nohadev.puntoventa.core.security.repository.RefreshTokenRepository;
import com.nohadev.puntoventa.core.security.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService{
    private final RefreshTokenRepository refreshTokenRepository;
    private final UsuarioRepository usuarioRepository;
    private final long REFRESH_EXPIRATION = 604800000;

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(String username){

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        RefreshToken token = new RefreshToken();

        token.setUsuario(usuario);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Instant.now().plusMillis(REFRESH_EXPIRATION));

        return refreshTokenRepository.save(token);
    }

    @Override
    public void verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException("Refresh token expirado");
        }
    }
}
