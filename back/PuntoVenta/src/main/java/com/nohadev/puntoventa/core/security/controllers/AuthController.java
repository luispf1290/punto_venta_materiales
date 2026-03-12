package com.nohadev.puntoventa.core.security.controllers;

import com.nohadev.puntoventa.core.security.dto.AuthenticationResponse;
import com.nohadev.puntoventa.core.security.dto.AuthenticationRequest;
import com.nohadev.puntoventa.core.security.service.AuthService;
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

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.Login(request));
    }

}
