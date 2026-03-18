package com.nohadev.puntoventa.inventario.service;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import com.nohadev.puntoventa.catalogo.repository.ProductoRepository;
import com.nohadev.puntoventa.inventario.dto.InventarioRequest;
import com.nohadev.puntoventa.inventario.dto.InventarioResponse;
import com.nohadev.puntoventa.inventario.entity.Almacen;
import com.nohadev.puntoventa.inventario.entity.Inventario;
import com.nohadev.puntoventa.inventario.mapper.InventarioMapper;
import com.nohadev.puntoventa.inventario.repository.AlmacenRepository;
import com.nohadev.puntoventa.inventario.repository.InventarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InventarioServiceImpl implements  InventarioService {
    private final InventarioRepository inventarioRepository;
    private final ProductoRepository productoRepository;
    private final AlmacenRepository almacenRepository;
    private final InventarioMapper inventarioMapper;

    @Override
    public InventarioResponse crearInventario(InventarioRequest request) {

        Producto producto = productoRepository.findById(request.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Almacen almacen = almacenRepository.findById(request.getAlmacenId())
                .orElseThrow(() -> new RuntimeException("Almacén no encontrado"));

        Inventario inventario = Inventario.builder()
                .producto(producto)
                .almacen(almacen)
                .exitencia_actual(request.getExitencia_actual())
                .build();

        inventarioRepository.save(inventario);

        return inventarioMapper.toDTO(inventario);

    }

    @Override
    public InventarioResponse obtenerInventario(Long productoId, Long almacenId) {
        Inventario inventario = inventarioRepository
                .findByProductoIdAndAlmacenId(productoId, almacenId)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

        return inventarioMapper.toDTO(inventario);
    }

    @Override
    public List<InventarioResponse> obtenerInventariosPorProducto(Long productoId) {
        return inventarioRepository.findByProductoId(productoId)
                .stream()
                .map(inventarioMapper::toDTO)
                .toList();
    }
}
