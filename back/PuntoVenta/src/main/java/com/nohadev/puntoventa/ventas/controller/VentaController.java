package com.nohadev.puntoventa.ventas.controller;

import com.nohadev.puntoventa.ventas.dto.VentaRequest;
import com.nohadev.puntoventa.ventas.dto.VentaResponse;
import com.nohadev.puntoventa.ventas.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {
    private final VentaService ventaService;

    @PostMapping
    public ResponseEntity<VentaResponse> crearVenta(@RequestBody VentaRequest request){
        return ResponseEntity.ok(ventaService.crearVenta(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaResponse> obtenerVenta(@PathVariable Long id){
        return ResponseEntity.ok(ventaService.obtenerVentaPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<VentaResponse>> obtenerTodasLasVentas(){
        return ResponseEntity.ok(ventaService.obtenerTodasLasVentas());
    }
}
