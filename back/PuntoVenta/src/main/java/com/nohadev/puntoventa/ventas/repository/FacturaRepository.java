package com.nohadev.puntoventa.ventas.repository;

import com.nohadev.puntoventa.ventas.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
