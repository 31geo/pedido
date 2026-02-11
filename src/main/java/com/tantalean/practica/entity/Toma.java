package com.tantalean.practica.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tomas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Toma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String dosis;

    @Column(nullable = false, length = 5)
    private String hora;

    private String frecuencia;

    private String notas;

    @Column(nullable = false)
    private Boolean activo = true;
}
