package com.nohadev.puntoventa.ventas.entity;

import com.nohadev.puntoventa.catalogo.entity.Cliente;
import com.nohadev.puntoventa.finanzas.entity.CuentasPorCobrar;
import com.nohadev.puntoventa.core.security.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ventas",
        indexes = {
            @Index(name = "idx_ventas_fecha", columnList = "fecha")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private  String folio;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(nullable = false)
    private BigDecimal subtotal;
    @Column(nullable = false)
    private BigDecimal iva;
    @Column(nullable = true)
    private BigDecimal descuento;
    @Column(nullable = false)
    private BigDecimal total;
    @Column(nullable = false)
    private String metodo_pago;
    //TODO: enum para estatus de venta
    private String estatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles;
}
