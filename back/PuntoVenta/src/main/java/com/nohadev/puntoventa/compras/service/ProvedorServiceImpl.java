package com.nohadev.puntoventa.compras.service;

import com.nohadev.puntoventa.compras.dto.ProvedorRequest;
import com.nohadev.puntoventa.compras.dto.ProvedorResponse;
import com.nohadev.puntoventa.compras.entity.Provedor;
import com.nohadev.puntoventa.compras.mapper.ProvedorMapper;
import com.nohadev.puntoventa.compras.repository.ProvedorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProvedorServiceImpl implements ProvedorService {

    private final ProvedorRepository provedorRepository;
    private final ProvedorMapper provedorMapper;

    @Override
    public ProvedorResponse creteProvedor(ProvedorRequest provedorRequest) {
        Provedor provedor = provedorMapper.toEntity(provedorRequest);

        provedor.setNombre(provedorRequest.getNombre());
        provedor.setTelefono(provedorRequest.getTelefono());
        provedor.setEmail(provedorRequest.getEmail());
        provedor.setDireccion(provedorRequest.getDireccion());
        provedor.setRfc(provedorRequest.getRfc());

        Provedor provedorSave = provedorRepository.save(provedor);

        return provedorMapper.toDTO(provedorSave);
    }

    @Override
    public ProvedorResponse updateProvedor(Long id, ProvedorRequest provedorRequest) {

        Provedor provedor = provedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        provedor.setNombre(provedorRequest.getNombre());
        provedor.setTelefono(provedorRequest.getTelefono());
        provedor.setEmail(provedorRequest.getEmail());
        provedor.setDireccion(provedorRequest.getDireccion());
        provedor.setRfc(provedorRequest.getRfc());

        Provedor provedorUpdate = provedorRepository.save(provedor);

        return provedorMapper.toDTO(provedorUpdate);
    }

    @Override
    public void deleteProvedor(Long id) {
        provedorRepository.deleteById(id);
    }

    @Override
    public ProvedorResponse getProvedorById(Long id) {
        Provedor provedor = provedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        return provedorMapper.toDTO(provedor);
    }

    @Override
    public List<ProvedorResponse> getAllProvedores() {
        return provedorRepository.findAll().stream()
                .map(provedorMapper::toDTO)
                .toList();
    }
}
