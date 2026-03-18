package com.nohadev.puntoventa.inventario.service;

import com.nohadev.puntoventa.inventario.dto.InventarioRequest;
import com.nohadev.puntoventa.inventario.dto.InventarioResponse;
import com.nohadev.puntoventa.inventario.entity.Inventario;

import java.util.List;

public interface InventarioService {
    InventarioResponse crearInventario(InventarioRequest request);
    InventarioResponse obtenerInventario(Long productoId, Long almacenId);
    List<InventarioResponse> obtenerInventariosPorProducto(Long productoId);
}
