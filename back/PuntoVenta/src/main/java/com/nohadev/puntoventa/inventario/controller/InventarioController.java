package com.nohadev.puntoventa.inventario.controller;

import com.nohadev.puntoventa.inventario.dto.InventarioRequest;
import com.nohadev.puntoventa.inventario.dto.InventarioResponse;
import com.nohadev.puntoventa.inventario.service.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class InventarioController {

    private final InventarioService inventarioService;

    @PostMapping
    public ResponseEntity<InventarioResponse> crearInventario(@RequestBody InventarioRequest inventarioRequest) {

        return ResponseEntity.ok(inventarioService.crearInventario(inventarioRequest));
    }

    @GetMapping
    public ResponseEntity<InventarioResponse> obtenerInventario(@RequestParam Long productoId, @RequestParam Long almacenId) {

        return ResponseEntity.ok(inventarioService.obtenerInventario(productoId, almacenId));
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<List<InventarioResponse>> obtenerInventariosPorProducto(@PathVariable Long id) {

        return ResponseEntity.ok(inventarioService.obtenerInventariosPorProducto(id));
    }
}
