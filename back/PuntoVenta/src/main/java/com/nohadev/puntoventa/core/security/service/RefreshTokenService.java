package com.nohadev.puntoventa.core.security.service;

import com.nohadev.puntoventa.core.security.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {
    Optional<RefreshToken> findByToken(String token);
    RefreshToken createRefreshToken(String username);
    void verifyExpiration(RefreshToken token);
}
