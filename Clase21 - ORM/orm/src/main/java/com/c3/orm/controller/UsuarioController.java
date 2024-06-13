package com.c3.orm.controller;

import com.c3.orm.entity.Usuario;
import com.c3.orm.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.saveUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos(){
        return ResponseEntity.ok(usuarioService.findAllUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findUsuarioById(id));
    }

    @PutMapping
    public ResponseEntity<String> actualizarUsuario(@RequestBody Usuario usuario){
        Optional<Usuario> usuarioBuscado= usuarioService.findUsuarioById(usuario.getId());
        if(usuarioBuscado.isPresent()){
            usuarioService.updateUsuario(usuario);
            return ResponseEntity.ok("Usuario actualizado con exito");
        }else{
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id){
        Optional<Usuario> usuarioBuscado = usuarioService.findUsuarioById(id);
        if (usuarioBuscado.isPresent()){
            usuarioService.deleteUsuario(id);
            return ResponseEntity.ok("Usuario eliminado con exito");
        }else {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }
    }
}