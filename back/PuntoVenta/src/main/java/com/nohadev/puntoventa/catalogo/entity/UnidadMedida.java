package com.nohadev.puntoventa.catalogo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unidade_medida")
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String clave_sat;
    @Column(nullable = false)
    private String nombre;
    private String abreviatura;

    @OneToMany(mappedBy = "unidadMedida", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoUnidad> productoUnidades = new ArrayList<>();

    public UnidadMedida() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClave_sat() {
        return clave_sat;
    }

    public void setClave_sat(String clave_sat) {
        this.clave_sat = clave_sat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public List<ProductoUnidad> getProductoUnidades() {
        return productoUnidades;
    }

    public void setProductoUnidades(List<ProductoUnidad> productoUnidades) {
        this.productoUnidades = productoUnidades;
    }
}
