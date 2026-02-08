package com.tantalean.pedido.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tantalean.pedido.entity.Clientes;
import com.tantalean.pedido.repository.ClienteRepository;
import com.tantalean.pedido.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Clientes> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Clientes> search(String texto, Pageable pageable) {
        if (texto == null || texto.isBlank()) {
            return repository.findAll(pageable);
        }
        return repository.findByRazonSocialContainsIgnoreCase(texto, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Clientes> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Clientes create(Clientes cliente) {
        return repository.save(cliente);
    }

    @Override
    @Transactional
    public Clientes update(Long id, Clientes cliente) {
        Clientes existente = repository.findById(id).orElseThrow();
        existente.setRazonSocial(cliente.getRazonSocial());
        existente.setDocumento(cliente.getDocumento());
        existente.setDireccion(cliente.getDireccion());
        existente.setTelefono(cliente.getTelefono());
        return repository.save(existente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
