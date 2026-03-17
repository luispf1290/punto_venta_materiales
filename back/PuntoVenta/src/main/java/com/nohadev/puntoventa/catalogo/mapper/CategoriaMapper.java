package com.nohadev.puntoventa.catalogo.mapper;

import com.nohadev.puntoventa.catalogo.dto.CategoriaRequest;
import com.nohadev.puntoventa.catalogo.dto.CategoriaResponse;
import com.nohadev.puntoventa.catalogo.entity.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaResponse toDTO(Categoria categoria);

    Categoria toEntity(CategoriaRequest categoriaRequest);
}
