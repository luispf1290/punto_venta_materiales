package com.nohadev.puntoventa.inventario.service;

import com.nohadev.puntoventa.inventario.dto.AlmacenRequest;
import com.nohadev.puntoventa.inventario.dto.AlmacenResponse;
import com.nohadev.puntoventa.inventario.entity.Almacen;
import com.nohadev.puntoventa.inventario.mapper.AlmacenMapper;
import com.nohadev.puntoventa.inventario.repository.AlmacenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlmacenServiceImpl implements AlmacenService {

    private final AlmacenRepository almacenRepository;
    private final AlmacenMapper almacenMapper;

    @Override
    public AlmacenResponse createAlmacen(AlmacenRequest almacenRequest) {
        Almacen almacen = almacenMapper.toEntity(almacenRequest);
        almacen.setNombre(almacenRequest.getNombre());
        almacen.setUbicacion(almacenRequest.getUbicacion());

        Almacen almacenSave = almacenRepository.save(almacen);

        return almacenMapper.toDTO(almacenSave);
    }

    @Override
    public AlmacenResponse updateAlmacen(Long id, AlmacenRequest almacenRequest) {
        Almacen almacen = almacenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Almacen no encontrado"));
        almacen.setNombre(almacenRequest.getNombre());
        almacen.setUbicacion(almacenRequest.getUbicacion());
        Almacen almacenUpdate = almacenRepository.save(almacen);

        return almacenMapper.toDTO(almacenUpdate);
    }

    @Override
    public void deleteAlmacen(Long id) {
        almacenRepository.deleteById(id);
    }

    @Override
    public AlmacenResponse getAlmacenById(Long id) {
        Almacen almacen = almacenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Almacen no encontrado"));
        return almacenMapper.toDTO(almacen);
    }

    @Override
    public List<AlmacenResponse> getAllAlmacenes() {
        return almacenRepository.findAll().stream()
                .map(almacenMapper::toDTO)
                .toList();
    }
}
