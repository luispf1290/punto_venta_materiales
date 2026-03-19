package com.nohadev.puntoventa.ventas.entity;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import com.nohadev.puntoventa.catalogo.entity.ProductoUnidad;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_venta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal cantidad;
    @Column(nullable = false)
    private BigDecimal precio_unitario;
    private BigDecimal descuento;
    @Column(nullable = false)
    private BigDecimal importe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_Id")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_unidad_id")
    private ProductoUnidad productoUnidad;
}
