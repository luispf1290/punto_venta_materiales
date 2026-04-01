package com.nohadev.puntoventa.catalogo.controller;

import com.nohadev.puntoventa.catalogo.dto.UnidadMedidaRequest;
import com.nohadev.puntoventa.catalogo.dto.UnidadMedidaResponse;
import com.nohadev.puntoventa.catalogo.service.UnidadMedidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidades")
@RequiredArgsConstructor
public class UnidadMedidaController {
    private final UnidadMedidaService service;

    @PostMapping
    public ResponseEntity<UnidadMedidaResponse> crear(@RequestBody UnidadMedidaRequest request){

        return ResponseEntity.ok(service.crearUnidadMedida(request));

    }

    @GetMapping
    public ResponseEntity<List<UnidadMedidaResponse>> listar(){

        return ResponseEntity.ok(service.obtenerUnidadesMedida());

    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadMedidaResponse> obtener(@PathVariable Long id){

        return ResponseEntity.ok(service.obtenerUnidadMedidaPorId(id));

    }
}
