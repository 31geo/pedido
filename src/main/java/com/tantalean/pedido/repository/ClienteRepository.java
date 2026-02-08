package com.tantalean.pedido.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tantalean.pedido.entity.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {
    Page<Clientes> findByRazonSocialContainsIgnoreCase(String razonSocial, Pageable pageable);
}
