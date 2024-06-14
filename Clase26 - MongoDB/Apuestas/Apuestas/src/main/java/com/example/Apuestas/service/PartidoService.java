package com.example.Apuestas.service;

import com.example.Apuestas.entity.Estado;
import com.example.Apuestas.entity.Partido;
import com.example.Apuestas.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    public Partido registrarPartido(Partido partido){
        return partidoRepository.save(partido);
    }
    public List<Partido> listarTodosPartidos(){ return partidoRepository.findAll(); }
    public List<Partido> buscarPartidoPorEstado(Estado estado){
        return partidoRepository.findPartidoByEstado(estado);
    }
}
