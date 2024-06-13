package com.example.directorTecnico.service;

import com.example.directorTecnico.entity.Jugador;
import com.example.directorTecnico.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jungadorRepository;

    public Jugador registrarJugador(Jugador jugador) {
        return null;
    }

    public Optional<Jugador> buscarJugador(Long id) {
        return jungadorRepository.findById(id);
    }


}
