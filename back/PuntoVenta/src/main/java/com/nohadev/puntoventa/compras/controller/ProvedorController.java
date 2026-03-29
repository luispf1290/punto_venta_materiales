package com.nohadev.puntoventa.compras.controller;

import com.nohadev.puntoventa.compras.dto.ProvedorRequest;
import com.nohadev.puntoventa.compras.dto.ProvedorResponse;
import com.nohadev.puntoventa.compras.service.ProvedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provedores")
@RequiredArgsConstructor
public class ProvedorController {
    private final ProvedorService provedorService;

    @PostMapping
    public ProvedorResponse createProvedor(@RequestBody ProvedorRequest provedorRequest) {
        return provedorService.creteProvedor(provedorRequest);
    }

    @GetMapping
    public List<ProvedorResponse> getAllProvedores() {
        return provedorService.getAllProvedores();
    }

    @GetMapping("/{id}")
    public ProvedorResponse getProvedorId(@PathVariable Long id){
        return provedorService.getProvedorById(id);
    }

    @PutMapping("/{id}")
    public ProvedorResponse updateProvedor(@PathVariable Long id, @RequestBody ProvedorRequest provedorRequest){
        return provedorService.updateProvedor(id, provedorRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProvedor(@PathVariable Long id){
        provedorService.deleteProvedor(id);
    }
}
