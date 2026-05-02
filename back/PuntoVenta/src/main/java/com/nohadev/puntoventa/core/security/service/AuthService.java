package com.nohadev.puntoventa.core.security.service;

import com.nohadev.puntoventa.core.security.dto.AuthenticationRequest;
import com.nohadev.puntoventa.core.security.dto.AuthenticationResponse;
import com.nohadev.puntoventa.core.security.dto.RefreshRequest;

public interface AuthService {
    AuthenticationResponse Login(AuthenticationRequest request);
    AuthenticationResponse RefreshToken(RefreshRequest request);
}
