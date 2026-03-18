package com.nohadev.puntoventa.inventario.controller;

import com.nohadev.puntoventa.inventario.dto.AlmacenRequest;
import com.nohadev.puntoventa.inventario.dto.AlmacenResponse;
import com.nohadev.puntoventa.inventario.service.AlmacenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequestMapping("/api/almacen")
@RequiredArgsConstructor
public class AlmacenController {
    private final AlmacenService almacenService;

    @PostMapping
    public AlmacenResponse createAlmacen(@RequestBody AlmacenRequest almacenRequest) {
        return almacenService.createAlmacen(almacenRequest);

    }

    @GetMapping
    public List<AlmacenResponse> getAllAlmacenes() {
        return almacenService.getAllAlmacenes();
    }

    @GetMapping("/{id}")
    public AlmacenResponse getAlmacenById(@RequestBody Long id) {
        return almacenService.getAlmacenById(id);

    }

    @PutMapping("/{id}")
    public AlmacenResponse updateAlmacen(@PathVariable Long id, @RequestBody AlmacenRequest almacenRequest) {
        return almacenService.updateAlmacen(id, almacenRequest);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        almacenService.deleteAlmacen(id);
    }

}
