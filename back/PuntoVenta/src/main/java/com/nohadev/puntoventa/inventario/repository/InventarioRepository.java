package com.nohadev.puntoventa.inventario.repository;

import com.nohadev.puntoventa.inventario.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    Optional<Inventario> findByProductoIdAndAlmacenId(Long productoId, Long almacenId);
    List<Inventario> findByProductoId(Long productoId);
}
