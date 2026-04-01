package com.nohadev.puntoventa.catalogo.entity;

import com.nohadev.puntoventa.ventas.entity.DetalleVenta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producto_unidades")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoUnidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal factor_conversion;
    private BigDecimal precio_venta;

    @OneToMany(mappedBy = "productoUnidad", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<DetalleVenta> detalleVentas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="unidad_id")
    private UnidadMedida unidadMedida;
}
