package com.nohadev.puntoventa.inventario.controller;

import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioRequest;
import com.nohadev.puntoventa.inventario.dto.MovimientoInventarioResponse;
import com.nohadev.puntoventa.inventario.service.MovimientoInventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario/movimientos")
@RequiredArgsConstructor
public class MovimientoInventarioController {
    private final MovimientoInventarioService movimientoInventarioService;

    @PostMapping
    public ResponseEntity<MovimientoInventarioResponse> registrarMovimiento(
            @RequestBody MovimientoInventarioRequest request){

        return  ResponseEntity.ok(movimientoInventarioService.registrarMovimientoInventario(request));
    }

    @GetMapping("/kardex/{productoId}")
    public ResponseEntity<?> obtenerKardexProducto(@PathVariable Long productoId){
        return ResponseEntity.ok(movimientoInventarioService.obtenerKardexProducto(productoId));
    }
}
