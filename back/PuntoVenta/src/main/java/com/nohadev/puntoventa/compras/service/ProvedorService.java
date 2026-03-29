package com.nohadev.puntoventa.compras.service;

import com.nohadev.puntoventa.compras.dto.ProvedorRequest;
import com.nohadev.puntoventa.compras.dto.ProvedorResponse;

import java.util.List;

public interface ProvedorService {
    ProvedorResponse creteProvedor(ProvedorRequest provedorRequest);
    ProvedorResponse updateProvedor(Long id, ProvedorRequest provedorRequest);
    void deleteProvedor(Long id);
    ProvedorResponse getProvedorById(Long id);
    List<ProvedorResponse> getAllProvedores();
}
