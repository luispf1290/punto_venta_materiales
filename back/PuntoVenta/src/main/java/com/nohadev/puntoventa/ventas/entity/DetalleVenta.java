package com.nohadev.puntoventa.ventas.entity;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import com.nohadev.puntoventa.catalogo.entity.ProductoUnidad;
import jakarta.persistence.*;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double cantidad;
    @Column(nullable = false)
    private Double precio_unitario;
    private Double descuento;
    @Column(nullable = false)
    private Double importe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_Id")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_unidad_id")
    private ProductoUnidad productoUnidad;


    public DetalleVenta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoUnidad getProductoUnidad() {
        return productoUnidad;
    }

    public void setProductoUnidad(ProductoUnidad productoUnidad) {
        this.productoUnidad = productoUnidad;
    }


}
