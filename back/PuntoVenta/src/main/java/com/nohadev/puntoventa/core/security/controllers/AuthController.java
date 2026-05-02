package com.nohadev.puntoventa.core.security.controllers;

import com.nohadev.puntoventa.core.security.dto.AuthenticationResponse;
import com.nohadev.puntoventa.core.security.dto.AuthenticationRequest;
import com.nohadev.puntoventa.core.security.dto.RefreshRequest;
import com.nohadev.puntoventa.core.security.entity.RefreshToken;
import com.nohadev.puntoventa.core.security.repository.RefreshTokenRepository;
import com.nohadev.puntoventa.core.security.service.AuthService;
import com.nohadev.puntoventa.core.security.service.RefreshTokenServiceImpl;
import com.nohadev.puntoventa.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtil jwtUtil;
    private final RefreshTokenServiceImpl refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.Login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody RefreshRequest request){
        RefreshToken token = refreshTokenRepository
                .findByToken(request.getRefreshToken())
                .orElseThrow();
        refreshTokenRepository.delete(token);

        return ResponseEntity.ok("Logged out successfully");

    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refresh(@RequestBody RefreshRequest request){
        return ResponseEntity.ok(authService.RefreshToken(request));
    }

}
