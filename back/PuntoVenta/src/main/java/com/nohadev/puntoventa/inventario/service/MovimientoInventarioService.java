package com.nohadev.puntoventa.inventario.service;

import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioRequest;
import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioResponse;
import com.nohadev.puntoventa.shared.Enums.TipoMovimiento;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface MovimientoInventarioService {
    @Transactional
    List<MovimientoInventarioResponse> obtenerKardexProducto(Long productoId);
    void procesarMovimientoInventario(MovimientoInventarioRequest request);
}
