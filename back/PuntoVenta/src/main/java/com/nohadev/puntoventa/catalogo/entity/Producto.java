package com.nohadev.puntoventa.catalogo.entity;

import com.nohadev.puntoventa.ventas.entity.DetalleVenta;
import com.nohadev.puntoventa.inventario.entity.Inventario;
import com.nohadev.puntoventa.inventario.entity.MovimientosInventario;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos",
        indexes = {
        @Index(name = "idx_producto_codigo", columnList = "codigo_barras")
})
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String codigo_barras;
    @Column(unique = true)
    private String sku;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private Double costo_promedio;
    @Column(nullable = false)
    private Double precio_venta;
    @Column(nullable = false)
    private Double stock_minimo;
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

    public Producto() {
    }

    public Producto(Long id, String codigo_barras, String sku, String descripcion, Double costo_promedio, Double precio_venta, Double stock_minimo, Boolean activo, Categoria categoria) {
        this.id = id;
        this.codigo_barras = codigo_barras;
        this.sku = sku;
        this.descripcion = descripcion;
        this.costo_promedio = costo_promedio;
        this.precio_venta = precio_venta;
        this.stock_minimo = stock_minimo;
        this.activo = activo;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Double getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(Double stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getCosto_promedio() {
        return costo_promedio;
    }

    public void setCosto_promedio(Double costo_promedio) {
        this.costo_promedio = costo_promedio;
    }

    public List<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }

    public List<ProductoUnidad> getProductoUnidades() {
        return productoUnidades;
    }

    public void setProductoUnidades(List<ProductoUnidad> productoUnidades) {
        this.productoUnidades = productoUnidades;
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    public List<MovimientosInventario> getMovimientosInventarios() {
        return movimientosInventarios;
    }

    public void setMovimientosInventarios(List<MovimientosInventario> movimientosInventarios) {
        this.movimientosInventarios = movimientosInventarios;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
