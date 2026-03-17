package com.nohadev.puntoventa.catalogo.mapper;

import com.nohadev.puntoventa.catalogo.dto.ProductoRequest;
import com.nohadev.puntoventa.catalogo.dto.ProductoResponse;
import com.nohadev.puntoventa.catalogo.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    @Mapping(source = "categoria.id", target = "categoria)")
    @Mapping(source="categoria.nombre", target = "categoriaNombre")
    @Mapping(source = "marca.id", target = "marca")
    @Mapping(source="marca.nombre", target = "marcaNombre")
    ProductoResponse toDTO(Producto producto);
    Producto toEntity(ProductoRequest productoRequest);
}
