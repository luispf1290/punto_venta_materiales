package com.nohadev.puntoventa.catalogo.controller;

import com.nohadev.puntoventa.catalogo.dto.CategoriaRequest;
import com.nohadev.puntoventa.catalogo.dto.CategoriaResponse;
import com.nohadev.puntoventa.catalogo.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping
    public CategoriaResponse createCategoria(@RequestBody CategoriaRequest categoriaRequest) {
        return categoriaService.createCategoria(categoriaRequest);
    }

    @GetMapping
    public List<CategoriaResponse> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaResponse getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    @PutMapping("/{id}")
    public CategoriaResponse updateCategoria(@PathVariable Long id, @RequestBody CategoriaRequest categoriaRequest) {
        return categoriaService.updateCategoria(id, categoriaRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }
}
