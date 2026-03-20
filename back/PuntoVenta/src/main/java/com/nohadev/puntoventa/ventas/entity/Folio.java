package com.nohadev.puntoventa.ventas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="folios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Folio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private Long ultimoNumero;
}
