package com.tantalean.practica.servicie.impl;

import com.tantalean.practica.entity.Toma;
import com.tantalean.practica.repository.TomaRepository;
import com.tantalean.practica.servicie.TomaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TomaServiceImpl implements TomaService {

    private final TomaRepository tomaRepository;

    @Override
    public List<Toma> listarTomas() {
        return tomaRepository.findAll();
    }

    @Override
    public Toma obtenerPorId(Integer id) {
        return tomaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Toma no encontrada con id: " + id));
    }

    @Override
    public Toma crearToma(Toma toma) {
        return tomaRepository.save(toma);
    }

    @Override
    public Toma actualizarToma(Integer id, Toma toma) {
        Toma existente = obtenerPorId(id);
        existente.setNombre(toma.getNombre());
        existente.setDosis(toma.getDosis());
        existente.setHora(toma.getHora());
        existente.setFrecuencia(toma.getFrecuencia());
        existente.setNotas(toma.getNotas());
        existente.setActivo(toma.getActivo());
        return tomaRepository.save(existente);
    }

    @Override
    public void eliminarToma(Integer id) {
        Toma existente = obtenerPorId(id);
        tomaRepository.delete(existente);
    }
}
