package com.tantalean.practica.repository;

import com.tantalean.practica.entity.Toma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TomaRepository extends JpaRepository<Toma, Integer> {

    List<Toma> findByActivoTrue();

    List<Toma> findByNombreContainingIgnoreCase(String nombre);
}
