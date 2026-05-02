package com.nohadev.puntoventa.core.security.service;

import com.nohadev.puntoventa.core.security.dto.AuthenticationRequest;
import com.nohadev.puntoventa.core.security.dto.AuthenticationResponse;
import com.nohadev.puntoventa.core.security.dto.RefreshRequest;
import com.nohadev.puntoventa.core.security.dto.UsuarioResponseDTO;
import com.nohadev.puntoventa.core.security.entity.RefreshToken;
import com.nohadev.puntoventa.core.security.entity.Usuario;
import com.nohadev.puntoventa.core.security.mapper.UsuarioMapper;
import com.nohadev.puntoventa.core.security.repository.UsuarioRepository;
import com.nohadev.puntoventa.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final RefreshTokenServiceImpl refreshTokenService;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public AuthenticationResponse Login(AuthenticationRequest request) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String token = jwtUtil.generateToken(userDetails.getUsername());

        RefreshToken refreshToken = refreshTokenService
                .createRefreshToken(userDetails.getUsername());

        Usuario usuario = usuarioRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));


        UsuarioResponseDTO usuarioResponse = usuarioMapper.toDTO(usuario);

        return new AuthenticationResponse(token,
                refreshToken.getToken(),
                usuarioResponse);
    }

    @Override
    public AuthenticationResponse RefreshToken(RefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        RefreshToken refreshToken = refreshTokenService.findByToken(requestRefreshToken)
                .orElseThrow(() -> new RuntimeException("Refresh token no encontrado"));

        refreshTokenService.verifyExpiration(refreshToken);

        Usuario usuario = refreshToken.getUsuario();
        String accessToken = jwtUtil.generateToken(usuario.getUsername());

        RefreshToken newRefreshToken = refreshTokenService.createRefreshToken(usuario.getUsername());

        UsuarioResponseDTO usuarioResponse = usuarioMapper.toDTO(usuario);

        return new AuthenticationResponse(accessToken,
                newRefreshToken.getToken(),
                usuarioResponse);
    }
}
