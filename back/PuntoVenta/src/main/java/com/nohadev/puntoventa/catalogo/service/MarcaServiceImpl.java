package com.nohadev.puntoventa.catalogo.service;

import com.nohadev.puntoventa.catalogo.dto.MarcaRequest;
import com.nohadev.puntoventa.catalogo.dto.MarcaResponse;
import com.nohadev.puntoventa.catalogo.entity.Marca;
import com.nohadev.puntoventa.catalogo.mapper.MarcaMapper;
import com.nohadev.puntoventa.catalogo.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;
    private final MarcaMapper marcaMapper;

    @Override
    public MarcaResponse createMarca(MarcaRequest marcaRequest) {

        Marca marca = marcaMapper.toEntity(marcaRequest);
        marca.setNombre(marcaRequest.getNombre());

        Marca marcaSave = marcaRepository.save(marca);

        return marcaMapper.toDTO(marcaSave);
    }

    @Override
    public MarcaResponse updateMarca(Long id, MarcaRequest marcaRequest) {

        Marca marca = marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
        marca.setNombre(marcaRequest.getNombre());
        Marca marcaUpdate = marcaRepository.save(marca);

        return marcaMapper.toDTO(marcaUpdate);
    }

    @Override
    public void deleteMarca(Long id) {
        marcaRepository.deleteById(id);
    }

    @Override
    public MarcaResponse getMarcaById(Long id) {
        Marca marca = marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
        return marcaMapper.toDTO(marca);
    }

    @Override
    public List<MarcaResponse> getAllMarcas() {
        return marcaRepository.findAll().stream()
                .map(marcaMapper::toDTO)
                .toList();
    }
}
