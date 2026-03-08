package com.nohadev.puntoventa.catalogo.entity;

import com.nohadev.puntoventa.finanzas.entity.CuentasPorCobrar;
import com.nohadev.puntoventa.ventas.entity.Venta;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String rfc;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String direccion;
    private Long limite_credito;
    private Integer dias_credito;
    private Boolean activo= true;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venta> ventas = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CuentasPorCobrar> cuentasPorCobrar = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String rfc, String telefono, String email, String direccion, Long limite_credito, Integer dias_credito, Boolean activo, List<Venta> ventas, List<CuentasPorCobrar> cuentasPorCobrar) {
        this.id = id;
        this.nombre = nombre;
        this.rfc = rfc;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.limite_credito = limite_credito;
        this.dias_credito = dias_credito;
        this.activo = activo;
        this.ventas = ventas;
        this.cuentasPorCobrar = cuentasPorCobrar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(Long limite_credito) {
        this.limite_credito = limite_credito;
    }

    public Integer getDias_credito() {
        return dias_credito;
    }

    public void setDias_credito(Integer dias_credito) {
        this.dias_credito = dias_credito;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<CuentasPorCobrar> getCuentasPorCobrar() {
        return cuentasPorCobrar;
    }

    public void setCuentasPorCobrar(List<CuentasPorCobrar> cuentasPorCobrar) {
        this.cuentasPorCobrar = cuentasPorCobrar;
    }


}
