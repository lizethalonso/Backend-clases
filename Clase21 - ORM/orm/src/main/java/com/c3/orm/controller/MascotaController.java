package com.c3.orm.controller;

import com.c3.orm.entity.Mascota;
import com.c3.orm.service.MascotaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @PostMapping
    public ResponseEntity<Mascota> guardarMascota (@RequestBody Mascota mascota){
        return ResponseEntity.ok(mascotaService.guardarMascota(mascota));
    }

    @GetMapping
    public ResponseEntity<List<Mascota>> listarMascotas(){
        return ResponseEntity.ok(mascotaService.buscarTodasMascotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Mascota>> buscarMascota(@PathVariable Long id){
        return ResponseEntity.ok(mascotaService.buscarMascotaPorId(id));
    }

    @PutMapping
    public ResponseEntity<Mascota> actualizarMascota(@RequestBody Mascota mascota){
        Optional<Mascota> mascotaBuscada = mascotaService.buscarMascotaPorId(mascota.getId());
        if (mascotaBuscada.isPresent()){
            return ResponseEntity.ok(mascotaService.actualizarMascota(mascota));
        }else {
            return ResponseEntity.noContent().build();
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarMascota(@PathVariable Long id){
        Optional<Mascota> mascota = mascotaService.buscarMascotaPorId(id);
        if (mascota.isPresent()){
            mascotaService.eliminarMascota(id);
            return ResponseEntity.ok("Eliminado");
        } else {
            return ResponseEntity.badRequest().body("No se encontró la mascota");
        }

    }

}
