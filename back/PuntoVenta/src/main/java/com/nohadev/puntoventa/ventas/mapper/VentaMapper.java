package com.nohadev.puntoventa.ventas.mapper;

import com.nohadev.puntoventa.ventas.dto.VentaResponse;
import com.nohadev.puntoventa.ventas.entity.Venta;
import org.springframework.stereotype.Component;

@Component
public interface VentaMapper {
    public  VentaResponse toDTO(Venta venta){
        return VentaResponse.builder()
                .id(venta.getId())
                .folio(venta.getFolio())
                .fecha(venta.getFecha())
                .subtotal(venta.getSubtotal())
                .iva(venta.getIva())
                .descuento(venta.getDescuento())
                .total(venta.getTotal())
                .metodo_pago(venta.getMetodo_pago())
                .estatus(venta.getEstatus())
                .build();
    }
}
