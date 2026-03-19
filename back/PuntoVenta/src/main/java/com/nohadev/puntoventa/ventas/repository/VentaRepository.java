package com.nohadev.puntoventa.ventas.repository;

import com.nohadev.puntoventa.ventas.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    Optional<Venta> findByFolio(String folio);
}
