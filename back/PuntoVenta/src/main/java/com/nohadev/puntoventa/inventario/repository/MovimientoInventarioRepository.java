package com.nohadev.puntoventa.inventario.repository;

import com.nohadev.puntoventa.inventario.entity.MovimientosInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoInventarioRepository extends JpaRepository<MovimientosInventario, Long> {
    List<MovimientosInventario> findByProductoIdOrderByFechaDesc(Long productoId);
}
