package com.nohadev.puntoventa.catalogo.service;

import com.nohadev.puntoventa.catalogo.dto.MarcaRequest;
import com.nohadev.puntoventa.catalogo.dto.MarcaResponse;

import java.util.List;

public interface MarcaService {
    MarcaResponse createMarca(MarcaRequest marcaRequest);
    MarcaResponse updateMarca(Long id, MarcaRequest marcaRequest);
    void deleteMarca(Long id);
    MarcaResponse getMarcaById(Long id);
    List<MarcaResponse> getAllMarcas();
}
