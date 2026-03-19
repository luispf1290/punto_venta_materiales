package com.nohadev.puntoventa.ventas.service;

import com.nohadev.puntoventa.ventas.entity.Folio;
import com.nohadev.puntoventa.ventas.repository.FolioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FolioService {

    private final FolioRepository folioRepository;

    @Transactional
    public String generarFolioVenta() {
        Folio folio = folioRepository.findByTipo("VENTA").orElseThrow();

        Long numero = folio.getUltimoNumero() + 1;
        folio.setUltimoNumero(numero);
        folioRepository.save(folio);

        return "VENTA-" + String.format("%06d", numero);
    }


}
