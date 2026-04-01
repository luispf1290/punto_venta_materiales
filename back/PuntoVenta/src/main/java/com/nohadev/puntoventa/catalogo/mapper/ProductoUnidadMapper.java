package com.nohadev.puntoventa.catalogo.mapper;

import com.nohadev.puntoventa.catalogo.dto.ProductoUnidadResponse;
import com.nohadev.puntoventa.catalogo.entity.ProductoUnidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoUnidadMapper {
    ProductoUnidadResponse toResponse(ProductoUnidad productoUnidad);
}
