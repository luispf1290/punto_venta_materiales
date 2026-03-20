package com.nohadev.puntoventa.catalogo.mapper;

import com.nohadev.puntoventa.catalogo.dto.ProductoRequest;
import com.nohadev.puntoventa.catalogo.dto.ProductoResponse;
import com.nohadev.puntoventa.catalogo.entity.Categoria;
import com.nohadev.puntoventa.catalogo.entity.Marca;
import com.nohadev.puntoventa.catalogo.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    @Mapping(source="categoria.nombre", target = "categoriaNombre")
    @Mapping(source="marca.nombre", target = "marcaNombre")
    ProductoResponse toDTO(Producto producto);

    @Mapping(source = "categoriaId", target = "categoria")
    @Mapping(source = "marcaId", target = "marca")
    Producto toEntity(ProductoRequest productoRequest);

    default Categoria mapCategoria(Long id) {
        if (id == null) return null;
        Categoria categoria = new Categoria();
        categoria.setId(id);
        return categoria;
    }

    default Marca mapMarca(Long id) {
        if (id == null) return null;
        Marca marca = new Marca();
        marca.setId(id);
        return marca;
    }
}
