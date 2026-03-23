package com.nohadev.puntoventa.catalogo.entity;

import com.nohadev.puntoventa.ventas.entity.DetalleVenta;
import com.nohadev.puntoventa.inventario.entity.Inventario;
import com.nohadev.puntoventa.inventario.entity.MovimientosInventario;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos",
        indexes = {
        @Index(name = "idx_producto_codigo", columnList = "codigo_barras")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(unique = true, nullable = false)
    private String codigo_barras;
    @Column(unique = true)
    private String sku;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal costo_promedio;
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal precio_venta;
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal costo_unitario;
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal stock_actual;
    private Boolean activo = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalleVentas = new ArrayList<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoUnidad> productoUnidades = new ArrayList<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventario> inventarios = new ArrayList<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovimientosInventario> movimientosInventarios = new ArrayList<>();
}
