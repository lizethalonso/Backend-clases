package com.example.tablaProfesor.controller;

import com.example.tablaProfesor.entity.Profesor;
import com.example.tablaProfesor.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<Profesor> guardarProfesor(@RequestBody Profesor profesor){
        return ResponseEntity.ok(profesorService.guardarProfesor(profesor));
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> listarProfesores() {
        return ResponseEntity.ok(profesorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProfesororId(@PathVariable Long id) {
        Optional<Profesor> profesorBuscado = profesorService.buscarPorId(id);
        if (profesorBuscado.isPresent()){
            return ResponseEntity.ok(profesorBuscado);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profesor no encontrado");
        }
    }

    @PutMapping()
    public ResponseEntity<?> actualizarProfesor(@RequestBody Profesor profesor) {
        Optional<Profesor> profesorBuscado = profesorService.buscarPorId(profesor.getId());
        if (profesorBuscado.isPresent()){
            profesorService.actualizarProfesor(profesor);
            return ResponseEntity.ok("Profesor actualizado con exito");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profesor no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable Long id){
        Optional<Profesor> profesorBuscado= profesorService.buscarPorId(id);
        if(profesorBuscado.isPresent()){
            profesorService.eliminarProfesor(id);
            return ResponseEntity.ok("profesor eliminado con exito");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
