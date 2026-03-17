package com.nohadev.puntoventa.catalogo.service;

import com.nohadev.puntoventa.catalogo.dto.CategoriaRequest;
import com.nohadev.puntoventa.catalogo.dto.CategoriaResponse;

import java.util.List;

public interface CategoriaService {
    CategoriaResponse createCategoria(CategoriaRequest categoriaRequest);
    CategoriaResponse updateCategoria(Long id, CategoriaRequest categoriaRequest);
    void deleteCategoria(Long id);
    CategoriaResponse getCategoriaById(Long id);
    List<CategoriaResponse> getAllCategorias();
}
