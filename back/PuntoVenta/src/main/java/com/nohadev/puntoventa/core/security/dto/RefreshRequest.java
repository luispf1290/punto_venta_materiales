package com.nohadev.puntoventa.core.security.dto;

import lombok.Data;

@Data
public class RefreshRequest {
    private String refreshToken;
}
