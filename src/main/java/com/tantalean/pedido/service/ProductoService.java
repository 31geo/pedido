package com.tantalean.pedido.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tantalean.pedido.entity.Producto;

public interface ProductoService {
        Page<Producto> findAll(Pageable pageable);
        Page<Producto> search(String texto, Pageable pageable);
        Optional<Producto> findById(Long id);
        Producto create(Producto producto);
        Producto update(Long id, Producto producto);
        void deleteById(Long id);

    }

