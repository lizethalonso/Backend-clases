package com.example.Apuestas.controller;

import com.example.Apuestas.entity.Partido;
import com.example.Apuestas.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partidos")
public class PartidoController {
    @Autowired
    private PartidoService partidoService;

    @PostMapping
    public ResponseEntity<Partido> registrarPartido(@RequestBody  Partido partido){
        return ResponseEntity.ok(partidoService.registrarPartido(partido));
    }

    @GetMapping
    public ResponseEntity<List<Partido>> listarPartidos(){
        return ResponseEntity.ok(partidoService.listarTodosPartidos());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Partido>> buscarPartidoEnVivo(@PathVariable String estado){
        return ResponseEntity.ok(partidoService.buscarPartidoEnVivo(estado));
    }

}
