package com.nohadev.puntoventa.inventario.entity;

import com.nohadev.puntoventa.catalogo.entity.Producto;
import com.nohadev.puntoventa.core.security.entity.Usuario;
import com.nohadev.puntoventa.shared.Enums.TipoMovimiento;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "movimientos_inventario",
indexes = {
        @Index(name="idx_kardex_producto_fecha", columnList = "fecha")
})
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class MovimientosInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimiento tipo_movimiento;

    private String tipo_documento;

    private Long id_documento;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal cantidad;

    @Column(precision = 19, scale = 4)
    private BigDecimal existenciaAnterior;

    @Column(precision = 19, scale = 4)
    private BigDecimal existenciaNueva;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal costo_unitario;

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
}
