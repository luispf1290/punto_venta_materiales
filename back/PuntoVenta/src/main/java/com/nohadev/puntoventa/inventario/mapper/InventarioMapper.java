package com.nohadev.puntoventa.inventario.mapper;

import com.nohadev.puntoventa.inventario.dto.InventarioResponse;
import com.nohadev.puntoventa.inventario.entity.Inventario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventarioMapper {
    @Mapping(target = "nombreProducto", source = "producto.nombre")
    @Mapping(target = "nombreAlmacen", source = "almacen.nombre")
    InventarioResponse toDTO(Inventario inventario);
}
