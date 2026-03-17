package com.nohadev.puntoventa.catalogo.repository;

import com.nohadev.puntoventa.catalogo.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
     Optional<Marca> findByNombre(String nombre);
}
