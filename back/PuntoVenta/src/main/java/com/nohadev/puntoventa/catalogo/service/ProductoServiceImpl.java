package com.nohadev.puntoventa.catalogo.service;

import com.nohadev.puntoventa.catalogo.dto.ProductoRequest;
import com.nohadev.puntoventa.catalogo.dto.ProductoResponse;
import com.nohadev.puntoventa.catalogo.entity.Categoria;
import com.nohadev.puntoventa.catalogo.entity.Marca;
import com.nohadev.puntoventa.catalogo.entity.Producto;
import com.nohadev.puntoventa.catalogo.mapper.ProductoMapper;
import com.nohadev.puntoventa.catalogo.repository.CategoriaRepository;
import com.nohadev.puntoventa.catalogo.repository.MarcaRepository;
import com.nohadev.puntoventa.catalogo.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl  implements  ProductoService{

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final MarcaRepository marcaRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoResponse> getAllProductos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toDTO)
                .toList();
    }

    @Override
    public ProductoResponse getProductoById(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return productoMapper.toDTO(producto);
    }

    @Override
    public ProductoResponse createProducto(ProductoRequest productoRequest) {
        Producto producto = productoMapper.toEntity(productoRequest);
        Categoria categoria = categoriaRepository.findById(productoRequest.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        Marca marca = marcaRepository.findById(productoRequest.getMarca_id())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));

        producto.setCategoria(categoria);
        producto.setMarca(marca);

        Producto productoSave = productoRepository.save(producto);

        return productoMapper.toDTO(productoSave);
    }

    @Override
    public ProductoResponse updateProducto(Long id, ProductoRequest productoRequest) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Categoria categoria = categoriaRepository.findById(productoRequest.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        Marca marca = marcaRepository.findById(productoRequest.getMarca_id())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));

        producto.setCodigo_barras(productoRequest.getCodigo_barras());
        producto.setSku(productoRequest.getSku());
        producto.setDescripcion(productoRequest.getDescripcion());
        producto.setCosto_promedio(productoRequest.getCosto_promedio());
        producto.setPrecio_venta(productoRequest.getPrecio_venta());
        producto.setStock_minimo(productoRequest.getStock_minimo());
        producto.setActivo(productoRequest.getActivo());
        producto.setCategoria(categoria);
        producto.setMarca(marca);

        Producto productoSave = productoRepository.save(producto);

        return productoMapper.toDTO(productoSave);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
