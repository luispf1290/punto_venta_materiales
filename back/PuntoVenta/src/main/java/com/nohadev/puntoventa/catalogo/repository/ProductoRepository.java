package com.nohadev.puntoventa.catalogo.repository;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
     Optional<Producto> findByCodigoBarras(String codigoBarras);
     Optional<Producto> findBySku(String sku);
}
