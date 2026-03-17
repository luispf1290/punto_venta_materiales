package com.nohadev.puntoventa.catalogo.mapper;

import com.nohadev.puntoventa.catalogo.dto.MarcaRequest;
import com.nohadev.puntoventa.catalogo.dto.MarcaResponse;
import com.nohadev.puntoventa.catalogo.entity.Marca;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarcaMapper {
    MarcaResponse toDTO(Marca marca);
    Marca toEntity(MarcaRequest marcaRequest);
}
