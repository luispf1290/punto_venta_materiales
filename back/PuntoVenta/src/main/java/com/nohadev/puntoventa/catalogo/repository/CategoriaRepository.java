package com.nohadev.puntoventa.catalogo.repository;

import com.nohadev.puntoventa.catalogo.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNombre(String nombre);
}
