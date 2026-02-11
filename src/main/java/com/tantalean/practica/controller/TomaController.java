package com.tantalean.practica.controller;

import com.tantalean.practica.entity.Toma;
import com.tantalean.practica.servicie.TomaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tomas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TomaController {

    private final TomaService tomaService;

    @GetMapping
    public ResponseEntity<List<Toma>> listar() {
        return ResponseEntity.ok(tomaService.listarTomas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Toma> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(tomaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Toma> crear(@RequestBody Toma toma) {
        return new ResponseEntity<>(tomaService.crearToma(toma), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Toma> actualizar(@PathVariable Integer id, @RequestBody Toma toma) {
        return ResponseEntity.ok(tomaService.actualizarToma(id, toma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        tomaService.eliminarToma(id);
        return ResponseEntity.noContent().build();
    }
}
