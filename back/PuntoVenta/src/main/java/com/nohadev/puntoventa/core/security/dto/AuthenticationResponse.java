package com.nohadev.puntoventa.core.security.dto;

public class AuthenticationResponse {
    private String jwToken;

    public String getJwToken() {
        return jwToken;
    }

    public AuthenticationResponse(String jwToken) {
        this.jwToken = jwToken;
    }

    public void setJwToken(String jwToken) {
        this.jwToken = jwToken;
    }
}
