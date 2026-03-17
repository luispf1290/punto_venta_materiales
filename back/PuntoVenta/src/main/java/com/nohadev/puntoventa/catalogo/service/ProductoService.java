package com.nohadev.puntoventa.catalogo.service;

import com.nohadev.puntoventa.catalogo.dto.ProductoRequest;
import com.nohadev.puntoventa.catalogo.dto.ProductoResponse;

import java.util.List;

public interface ProductoService {
    List<ProductoResponse> getAllProductos();

    ProductoResponse getProductoById(Long id);

    ProductoResponse createProducto(ProductoRequest productoRequest);

    ProductoResponse updateProducto(Long id, ProductoRequest productoRequest);

    void deleteProducto(Long id);
}
