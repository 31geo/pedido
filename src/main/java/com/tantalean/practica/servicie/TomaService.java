package com.tantalean.practica.servicie;

import com.tantalean.practica.entity.Toma;

import java.util.List;

public interface TomaService {

    List<Toma> listarTomas();

    Toma obtenerPorId(Integer id);

    Toma crearToma(Toma toma);

    Toma actualizarToma(Integer id, Toma toma);

    void eliminarToma(Integer id);
}
