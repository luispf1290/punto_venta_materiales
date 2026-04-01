package com.nohadev.puntoventa.catalogo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unidad_medida")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
