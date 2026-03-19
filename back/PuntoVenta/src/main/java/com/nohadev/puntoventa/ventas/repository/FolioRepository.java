package com.nohadev.puntoventa.ventas.repository;

import com.nohadev.puntoventa.ventas.entity.Folio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FolioRepository extends JpaRepository<Folio, Long> {
    Optional<Folio> findByTipo(String tipo);
}
