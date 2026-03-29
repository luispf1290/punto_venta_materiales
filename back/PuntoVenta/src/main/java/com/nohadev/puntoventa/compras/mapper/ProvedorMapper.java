package com.nohadev.puntoventa.compras.mapper;

import com.nohadev.puntoventa.compras.dto.ProvedorRequest;
import com.nohadev.puntoventa.compras.dto.ProvedorResponse;
import com.nohadev.puntoventa.compras.entity.Provedor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProvedorMapper {
    ProvedorResponse toDTO(Provedor provedor);
    Provedor toEntity(ProvedorRequest provedorRequest);
}
