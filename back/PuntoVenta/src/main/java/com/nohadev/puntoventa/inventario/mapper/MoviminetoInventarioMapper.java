package com.nohadev.puntoventa.inventario.mapper;

import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioResponse;
import com.nohadev.puntoventa.inventario.entity.MovimientosInventario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MoviminetoInventarioMapper {
    @Mapping(source = "producto.nombre", target = "nombreProducto")
    @Mapping(source = "almacen.nombre", target = "nombreAlmacen")
    MovimientoInventarioResponse toDTO(MovimientosInventario movimientoInventario);
}
