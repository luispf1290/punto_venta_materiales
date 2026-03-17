package com.nohadev.puntoventa.catalogo.controller;

import com.nohadev.puntoventa.catalogo.dto.ProductoRequest;
import com.nohadev.puntoventa.catalogo.dto.ProductoResponse;
import com.nohadev.puntoventa.catalogo.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ProductoResponse createProducto(@RequestBody ProductoRequest productoRequest) {
        return productoService.createProducto(productoRequest);
    }

    @GetMapping
    public List<ProductoResponse> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ProductoResponse getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @PutMapping("/{id}")
    public ProductoResponse updateProducto(@PathVariable Long id, @RequestBody ProductoRequest productoRequest) {
        return productoService.updateProducto(id, productoRequest);
    }

    @DeleteMapping("{/id}")
    public void eliminar(@PathVariable Long id){
        productoService.deleteProducto(id);
    }
}
