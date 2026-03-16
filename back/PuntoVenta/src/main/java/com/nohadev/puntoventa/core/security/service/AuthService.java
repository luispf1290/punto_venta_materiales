package com.nohadev.puntoventa.core.security.service;

import com.nohadev.puntoventa.core.security.dto.AuthenticationRequest;
import com.nohadev.puntoventa.core.security.dto.AuthenticationResponse;

public interface AuthService {
    AuthenticationResponse Login(AuthenticationRequest request);
}
