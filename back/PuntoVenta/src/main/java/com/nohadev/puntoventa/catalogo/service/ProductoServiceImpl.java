package com.nohadev.puntoventa.catalogo.service;

import com.nohadev.puntoventa.catalogo.dto.ProductoRequest;
import com.nohadev.puntoventa.catalogo.dto.ProductoResponse;
import com.nohadev.puntoventa.catalogo.dto.ProductoUnidadRequest;
import com.nohadev.puntoventa.catalogo.entity.*;
import com.nohadev.puntoventa.catalogo.mapper.ProductoMapper;
import com.nohadev.puntoventa.catalogo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl  implements  ProductoService{

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final MarcaRepository marcaRepository;
    private  final UnidadMedidaRepository unidadMedidaRepository;
    private final ProductoUnidadRepository productoUnidadRepository;
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

        Marca marca = marcaRepository.findById(productoRequest.getMarcaId())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));

        producto.setCategoria(categoria);
        producto.setMarca(marca);

        Producto productoSave = productoRepository.save(producto);

        if (productoRequest.getUnidades() != null) {
            for (ProductoUnidadRequest unidadRequest : productoRequest.getUnidades()) {
                UnidadMedida unidadMedida = unidadMedidaRepository.findById(unidadRequest.getUnidadMedidaId())
                        .orElseThrow(() -> new RuntimeException("Unidad de medida no encontrada"));

                ProductoUnidad productoUnidad = new ProductoUnidad();

                productoUnidad.setProducto(productoSave);
                productoUnidad.setUnidadMedida(unidadMedida);
                productoUnidad.setFactor_conversion(unidadRequest.getFactorConversion());
                productoUnidad.setPrecio_venta(unidadRequest.getPrecioVenta());
                productoUnidadRepository.save(productoUnidad);
            }
        }

        return productoMapper.toDTO(productoSave);
    }

    @Override
    public ProductoResponse updateProducto(Long id, ProductoRequest productoRequest) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Categoria categoria = categoriaRepository.findById(productoRequest.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        Marca marca = marcaRepository.findById(productoRequest.getMarcaId())
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
        if (productoRequest.getUnidades() != null) {
            for (ProductoUnidadRequest unidadRequest : productoRequest.getUnidades()) {
                UnidadMedida unidadMedida = unidadMedidaRepository.findById(unidadRequest.getUnidadMedidaId())
                        .orElseThrow(() -> new RuntimeException("Unidad de medida no encontrada"));

                ProductoUnidad productoUnidad = new ProductoUnidad();

                productoUnidad.setProducto(productoSave);
                productoUnidad.setUnidadMedida(unidadMedida);
                productoUnidad.setFactor_conversion(unidadRequest.getFactorConversion());
                productoUnidad.setPrecio_venta(unidadRequest.getPrecioVenta());
                productoUnidadRepository.save(productoUnidad);
            }
        }

        return productoMapper.toDTO(productoSave);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
