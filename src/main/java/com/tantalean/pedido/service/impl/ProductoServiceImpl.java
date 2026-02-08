package com.tantalean.pedido.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tantalean.pedido.entity.Producto;
import com.tantalean.pedido.repository.ProductoRepository;
import com.tantalean.pedido.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> search(String texto, Pageable pageable) {
        if (texto == null || texto.isBlank()) {
            return repository.findAll(pageable);
        }

        return repository.findByNombreContainsIgnoreCase(texto, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Producto create(Producto producto) {
        return repository.save(producto);
    }

    @Override
    @Transactional
    public Producto update(Long id, Producto producto) {
        Producto existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        existente.setNombre(producto.getNombre());
        // Si tu entidad tiene descripción, la seteas; si no, elimínala
        // existente.setDescripcion(producto.getDescripcion());
        existente.setCodigo(producto.getCodigo());
        existente.setPrecioUnitario(producto.getPrecioUnitario());

        return repository.save(existente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }
        repository.deleteById(id);
    }
}
