package com.nohadev.puntoventa.inventario.service;

import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioRequest;
import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioResponse;

import java.util.List;

public interface MovimientoInventarioService {
    MovimientoInventarioResponse registrarMovimientoInventario(MovimientoInventarioRequest request);
    List<MovimientoInventarioResponse> obtenerKardexProducto(Long productoId);
}
