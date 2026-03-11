package com.nohadev.puntoventa.core.security.controllers;

import com.nohadev.puntoventa.core.security.service.JWTService;
import com.nohadev.puntoventa.core.security.service.UsuarioDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioDetailServiceImpl usuarioDetailService;
    @Autowired
    private JWTService jwtService;

    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRquest request){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken()
            );
        }catch (){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        final UserDetails userDetails = usuarioDetailService.loadUserByUsername();
        final String jwtToken = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }

}
