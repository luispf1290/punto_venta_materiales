package com.nohadev.puntoventa.catalogo.controller;

import com.nohadev.puntoventa.catalogo.dto.MarcaRequest;
import com.nohadev.puntoventa.catalogo.dto.MarcaResponse;
import com.nohadev.puntoventa.catalogo.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;

    @PostMapping
    public MarcaResponse createMarca(@RequestBody MarcaRequest marcaRequest) {
        return marcaService.createMarca(marcaRequest);
    }

    @GetMapping
    public List<MarcaResponse> getAllMarcas() {
        return marcaService.getAllMarcas();
    }

    @GetMapping("/{id}")
    public MarcaResponse getMarcaById(@PathVariable Long id) {
        return marcaService.getMarcaById(id);
    }

    @PutMapping("/{id}")
    public MarcaResponse updateMarca(@PathVariable Long id, @RequestBody MarcaRequest marcaRequest) {
        return marcaService.updateMarca(id, marcaRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMarca(@PathVariable Long id) {
        marcaService.deleteMarca(id);
    }
}
