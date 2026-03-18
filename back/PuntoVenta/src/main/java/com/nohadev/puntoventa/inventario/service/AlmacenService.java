package com.nohadev.puntoventa.inventario.service;

import com.nohadev.puntoventa.inventario.dto.AlmacenRequest;
import com.nohadev.puntoventa.inventario.dto.AlmacenResponse;

import java.util.List;

public interface AlmacenService {
    AlmacenResponse createAlmacen(AlmacenRequest almacenRequest);
    AlmacenResponse updateAlmacen(Long id, AlmacenRequest almacenRequest);
    void deleteAlmacen(Long id);
    AlmacenResponse getAlmacenById(Long id);
    List<AlmacenResponse> getAllAlmacenes();
}
