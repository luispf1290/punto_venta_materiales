package com.nohadev.puntoventa.ventas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String uuid;
    @Column(unique = true, nullable = false)
    private String serie;
    @Column(unique = true, nullable = false)
    private String folio;
    private LocalDate fecha;
    @Lob
    @Column(name = "xml", columnDefinition = "LONGTEXT")
    private String xml;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ventas_id")
    private Venta venta;


}
