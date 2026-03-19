package com.nohadev.puntoventa.ventas.repository;

import com.nohadev.puntoventa.ventas.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

}
