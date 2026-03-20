package com.nohadev.puntoventa.catalogo.repository;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
     /*Optional<Producto> findByCodigoBarras(String codigo_barras);
     Optional<Producto> findBySku(String sku);
     boolean exitsByCodigoBarras(String codigo_barras);
     boolean exitsBySku(String sku);*/
}
