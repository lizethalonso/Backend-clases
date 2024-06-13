package com.example.tablaProfesor.controller;

import com.example.tablaProfesor.entity.Estudiante;
import com.example.tablaProfesor.service.EstudianteService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.guardarEstudiante(estudiante));
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        return ResponseEntity.ok(estudianteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEstudiantePorId(@PathVariable Long id) {
        Optional<Estudiante> estudianteBuscado = estudianteService.buscarPorId(id);
        if (estudianteBuscado.isPresent()){
            return ResponseEntity.ok(estudianteBuscado);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado");
        }
    }

    @PutMapping()
    public ResponseEntity<?> actualizarEstudiante(@RequestBody Estudiante estudiante) {
        Optional<Estudiante> estudianteBuscado = estudianteService.buscarPorId(estudiante.getId());
        if (estudianteBuscado.isPresent()){
            return ResponseEntity.ok(estudianteService.actualizarEstudiante(estudiante));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstudiante(@PathVariable Long id){
        Optional<Estudiante> estudianteBuscado = estudianteService.buscarPorId(id);
        if(estudianteBuscado.isPresent()){
            estudianteService.eliminarEstudiante(id);
            return ResponseEntity.ok("Estudiante eliminado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
