package com.nohadev.puntoventa.inventario.entity;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "inventario",
uniqueConstraints = {
        @UniqueConstraint(columnNames = {"producto_id", "almacen_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal exitencia_actual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "almacen_id")
    private Almacen almacen;
}
