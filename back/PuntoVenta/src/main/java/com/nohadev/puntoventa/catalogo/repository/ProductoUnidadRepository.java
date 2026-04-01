package com.nohadev.puntoventa.catalogo.repository;

import com.nohadev.puntoventa.catalogo.entity.ProductoUnidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoUnidadRepository extends JpaRepository<ProductoUnidad, Long> {

}
