package com.nohadev.puntoventa.inventario.entity;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import com.nohadev.puntoventa.core.config.Usuario;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "movimientos_inventario",
indexes = {
        @Index(name="idx_kardex_producto_fecha", columnList = "fecha")
})
public class MovimientosInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tipo_movimiento;
    private String tipo_documento;
    private Long id_documento;
    @Column(nullable = false)
    private Double cantidad;
    private BigDecimal existenciaAnterior;
    private BigDecimal existenciaNueva;
    @Column(nullable = false)
    private Double costo_unitario;
    @Column(nullable = false)
    private LocalDate fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "almacen_id")
    private Almacen almacen;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public MovimientosInventario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    /* Tipo de documento : Venta,  Compra, Inventario*/
    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    /* id del documento realizado */
    public Long getId_documento() {
        return id_documento;
    }

    public void setId_documento(Long id_documento) {
        this.id_documento = id_documento;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(Double costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getExistenciaAnterior() {
        return existenciaAnterior;
    }

    public void setExistenciaAnterior(BigDecimal existenciaAnterior) {
        this.existenciaAnterior = existenciaAnterior;
    }

    public BigDecimal getExistenciaNueva() {
        return existenciaNueva;
    }

    public void setExistenciaNueva(BigDecimal existenciaNueva) {
        this.existenciaNueva = existenciaNueva;
    }
}
