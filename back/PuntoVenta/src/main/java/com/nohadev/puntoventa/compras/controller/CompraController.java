package com.nohadev.puntoventa.compras.controller;

import com.nohadev.puntoventa.compras.dto.CompraRequest;
import com.nohadev.puntoventa.compras.dto.CompraResponse;
import com.nohadev.puntoventa.compras.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
@RequiredArgsConstructor
public class CompraController {
    private final CompraService compraService;

    @PostMapping
    public ResponseEntity<CompraResponse> crearCompra(@RequestBody CompraRequest request){
        return ResponseEntity.ok(compraService.crearCompra(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraResponse> obtenerCompra(@PathVariable Long id) {
        return ResponseEntity.ok(compraService.obtenerCompraPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<CompraResponse>> obtenerTodasLasCompras() {
        return ResponseEntity.ok(compraService.obtenerTodasLasCompras());
    }
}
