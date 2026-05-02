package com.nohadev.puntoventa.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String SECRET;

    @Value("${jwt.expiration}")
    private long expirationTimeMillis;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username){
        SecretKey key = getSigningKey();
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTimeMillis))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token){
        ;
        if(token == null) return null;
        if(!token.startsWith("Bearer ")) token = token.substring(7);
        token = token.trim();
        token = token.replaceAll("^\"|\"$", ""); // elimina comillas envolventes

        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Token no tiene 3 partes: " + token);
        }

        if (!parts[0].matches("^[A-Za-z0-9\\-_]+$")) {
            throw new IllegalArgumentException("Header JWT contiene caracteres inválidos");
        }

        try{
            SecretKey key = getSigningKey();
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        }catch (io.jsonwebtoken.MalformedJwtException e){
            // log detallado en desarrollo y devolver null o lanzar excepción controlada
            System.out.println("MalformedJwtException al parsear token: " + token);
            throw e;
        }catch (Exception e){
            // log general para otras excepciones
            System.out.println("Error al validar JWT: " + e.getMessage());
            throw e;
        }

    }
}
