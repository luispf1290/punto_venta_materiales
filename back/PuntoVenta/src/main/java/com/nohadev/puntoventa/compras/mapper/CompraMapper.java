package com.nohadev.puntoventa.compras.mapper;

import com.nohadev.puntoventa.compras.dto.CompraResponse;
import com.nohadev.puntoventa.compras.entity.Compra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompraMapper {
    @Mapping(source="proveedor.nombre", target = "nombreProveedor")
    @Mapping(source="usuario.nombre", target = "nombreUsuario")
    CompraResponse toDTO(Compra compra);
}
