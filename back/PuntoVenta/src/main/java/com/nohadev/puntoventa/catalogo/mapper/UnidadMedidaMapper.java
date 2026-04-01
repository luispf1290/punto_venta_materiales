package com.nohadev.puntoventa.catalogo.mapper;

import com.nohadev.puntoventa.catalogo.dto.UnidadMedidaRequest;
import com.nohadev.puntoventa.catalogo.dto.UnidadMedidaResponse;
import com.nohadev.puntoventa.catalogo.entity.UnidadMedida;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnidadMedidaMapper {
    UnidadMedidaResponse toUnidadMedidaResponse(UnidadMedida unidadMedida);
    UnidadMedida toEntity(UnidadMedidaRequest unidadMedidaRequest);
}
