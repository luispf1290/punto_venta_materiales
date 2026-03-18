package com.nohadev.puntoventa.inventario.mapper;

import com.nohadev.puntoventa.inventario.dto.AlmacenRequest;
import com.nohadev.puntoventa.inventario.dto.AlmacenResponse;
import com.nohadev.puntoventa.inventario.entity.Almacen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlmacenMapper {
    AlmacenResponse toDTO(Almacen almacen);
    Almacen toEntity(AlmacenRequest almacenRequest);
}
