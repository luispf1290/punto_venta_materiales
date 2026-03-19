package com.nohadev.puntoventa.ventas.service;

import com.nohadev.puntoventa.ventas.entity.Factura;
import com.nohadev.puntoventa.ventas.entity.Venta;
import com.nohadev.puntoventa.ventas.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public Factura crearFactura(Venta venta) {
        Factura factura = new Factura();
        factura.setVenta(venta);
        factura.setFecha(LocalDate.now());
        factura.setSerie("A");
        factura.setFolio(venta.getFolio());
        factura.setUuid(UUID.randomUUID().toString());

        return facturaRepository.save(factura);
    }
}
