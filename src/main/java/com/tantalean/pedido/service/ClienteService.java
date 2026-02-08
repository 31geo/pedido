package com.tantalean.pedido.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tantalean.pedido.entity.Clientes;

public interface ClienteService {
    Page<Clientes> findAll(Pageable pageable);
    Page<Clientes> search(String texto, Pageable pageable);
    Optional<Clientes> findById(Long id);
    Clientes create(Clientes cliente);
    Clientes update(Long id, Clientes cliente);
    void deleteById(Long id);
}
