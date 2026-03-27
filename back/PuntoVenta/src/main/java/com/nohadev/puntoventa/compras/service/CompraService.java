package com.nohadev.puntoventa.compras.service;

import com.nohadev.puntoventa.compras.dto.CompraRequest;
import com.nohadev.puntoventa.compras.dto.CompraResponse;

import java.util.List;

public interface CompraService {
    CompraResponse crearCompra(CompraRequest compraRequest);
    CompraResponse obtenerCompraPorId(Long id);
    List<CompraResponse> obtenerTodasLasCompras();
}
