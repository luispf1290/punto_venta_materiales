package com.nohadev.puntoventa.ventas.mapper;

import com.nohadev.puntoventa.ventas.dto.VentaResponse;
import com.nohadev.puntoventa.ventas.entity.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    VentaResponse toDTO(Venta venta);
}
