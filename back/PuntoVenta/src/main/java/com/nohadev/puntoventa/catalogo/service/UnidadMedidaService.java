package com.nohadev.puntoventa.catalogo.service;

import com.nohadev.puntoventa.catalogo.dto.UnidadMedidaRequest;
import com.nohadev.puntoventa.catalogo.dto.UnidadMedidaResponse;

import java.util.List;

public interface UnidadMedidaService {

    UnidadMedidaResponse crearUnidadMedida(UnidadMedidaRequest request);
    List<UnidadMedidaResponse> obtenerUnidadesMedida();
    UnidadMedidaResponse obtenerUnidadMedidaPorId(Long id);
    UnidadMedidaResponse actualizarUnidadMedida(Long id, UnidadMedidaRequest request);
    void eliminarUnidadMedida(Long id);
}
