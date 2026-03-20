package com.nohadev.puntoventa.ventas.mapper;

import com.nohadev.puntoventa.ventas.dto.VentaResponse;
import com.nohadev.puntoventa.ventas.entity.Venta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    @Mapping(source="cliente.nombre", target = "nombreCliente")
    @Mapping(source="usuario.nombre", target = "nombreUsuario")
    VentaResponse toDTO(Venta venta);
}
