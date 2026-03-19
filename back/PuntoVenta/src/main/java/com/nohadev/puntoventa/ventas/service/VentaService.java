package com.nohadev.puntoventa.ventas.service;

import com.nohadev.puntoventa.ventas.dto.VentaRequest;
import com.nohadev.puntoventa.ventas.dto.VentaResponse;

import java.util.List;

public interface VentaService {
    VentaResponse crearVenta(VentaRequest ventaRequest);
    VentaResponse obtenerVentaPorId(Long id);
    List<VentaResponse> obtenerTodasLasVentas();
    /*VentaResponse actualizarVenta(Long id, VentaRequest ventaRequest);
    void eliminarVenta(Long id);*/
}
