package com.nohadev.puntoventa.compras.repository;

import com.nohadev.puntoventa.compras.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}
