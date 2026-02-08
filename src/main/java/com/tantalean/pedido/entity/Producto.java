package com.tantalean.pedido.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "productos")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 20, unique = true)
    private String codigo;
    @Column(length = 200)
    private String descripcion;
    @Column(nullable = false)
    private BigDecimal precioUnitario;

}
