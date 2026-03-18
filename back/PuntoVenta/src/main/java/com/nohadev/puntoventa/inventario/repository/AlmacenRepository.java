package com.nohadev.puntoventa.inventario.repository;

import com.nohadev.puntoventa.inventario.entity.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlmacenRepository extends JpaRepository<Almacen, Long> {
    Optional<Almacen> findByNombre(String nombre);
}
