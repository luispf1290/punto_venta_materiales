package com.nohadev.puntoventa.core.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class AuthenticationResponse {
    private String jwToken;
    private String refreshToken;
}
