package com.nohadev.puntoventa.catalogo.service;

import com.nohadev.puntoventa.catalogo.dto.CategoriaRequest;
import com.nohadev.puntoventa.catalogo.dto.CategoriaResponse;
import com.nohadev.puntoventa.catalogo.entity.Categoria;
import com.nohadev.puntoventa.catalogo.mapper.CategoriaMapper;
import com.nohadev.puntoventa.catalogo.repository.CategoriaRepository;
import com.nohadev.puntoventa.catalogo.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService{

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public CategoriaResponse createCategoria(CategoriaRequest categoriaRequest) {

        Categoria categoria = categoriaMapper.toEntity(categoriaRequest);

        categoria.setNombre(categoriaRequest.getNombre());
        categoria.setDescripcion(categoriaRequest.getDescripcion());

        Categoria categoriaSave = categoriaRepository.save(categoria);

        return categoriaMapper.toDTO(categoriaSave);
    }

    @Override
    public CategoriaResponse updateCategoria(Long id, CategoriaRequest categoriaRequest) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        categoria.setNombre(categoriaRequest.getNombre());
        categoria.setDescripcion(categoriaRequest.getDescripcion());
        Categoria categoriaUpdate = categoriaRepository.save(categoria);

        return categoriaMapper.toDTO(categoriaUpdate);
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public CategoriaResponse getCategoriaById(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        return categoriaMapper.toDTO(categoria);
    }

    @Override
    public List<CategoriaResponse> getAllCategorias() {
        return categoriaRepository.findAll().stream()
                .map(categoriaMapper::toDTO)
                .toList();
    }
}
