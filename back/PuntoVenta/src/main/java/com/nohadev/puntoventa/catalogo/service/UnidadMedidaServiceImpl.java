package com.nohadev.puntoventa.catalogo.service;

import com.nohadev.puntoventa.catalogo.dto.UnidadMedidaRequest;
import com.nohadev.puntoventa.catalogo.dto.UnidadMedidaResponse;
import com.nohadev.puntoventa.catalogo.entity.UnidadMedida;
import com.nohadev.puntoventa.catalogo.mapper.UnidadMedidaMapper;
import com.nohadev.puntoventa.catalogo.repository.UnidadMedidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnidadMedidaServiceImpl implements UnidadMedidaService {

    private final UnidadMedidaRepository unidadMedidaRepository;
    private final UnidadMedidaMapper unidadMedidaMapper;

    @Override
    public UnidadMedidaResponse crearUnidadMedida(UnidadMedidaRequest request) {
        UnidadMedida unidadMedida = unidadMedidaMapper.toEntity(request);
        UnidadMedida unidadMedidaSave = unidadMedidaRepository.save(unidadMedida);
        return unidadMedidaMapper.toUnidadMedidaResponse(unidadMedidaSave);
    }

    @Override
    public List<UnidadMedidaResponse> obtenerUnidadesMedida() {
        // Implementar lógica para obtener todas las unidades de medida
        return unidadMedidaRepository.findAll()
                .stream()
                .map(unidadMedidaMapper::toUnidadMedidaResponse)
                .toList();
    }

    @Override
    public UnidadMedidaResponse obtenerUnidadMedidaPorId(Long id) {
        UnidadMedida unidadMedida = unidadMedidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidad de medida no encontrada"));

        return unidadMedidaMapper.toUnidadMedidaResponse(unidadMedida);
    }

    @Override
    public UnidadMedidaResponse actualizarUnidadMedida(Long id, UnidadMedidaRequest request) {
        // Implementar lógica para actualizar una unidad de medida existente
        return null;
    }

    @Override
    public void eliminarUnidadMedida(Long id) {
        // Implementar lógica para eliminar una unidad de medida por su ID
    }
}
