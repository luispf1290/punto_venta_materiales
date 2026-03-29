package com.nohadev.puntoventa.compras.repository;

import com.nohadev.puntoventa.compras.entity.Provedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProvedorRepository extends JpaRepository<Provedor, Long> {
    Optional<Provedor> findByNombre(String nombre);
    Optional<Provedor> findByrfc(String rfc);
}
