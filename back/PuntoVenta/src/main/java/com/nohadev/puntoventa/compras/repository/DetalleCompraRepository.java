package com.nohadev.puntoventa.compras.repository;

import com.nohadev.puntoventa.compras.entity.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {
}
