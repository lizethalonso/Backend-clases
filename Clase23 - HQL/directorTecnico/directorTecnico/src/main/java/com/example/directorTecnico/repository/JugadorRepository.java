package com.example.directorTecnico.repository;

import com.example.directorTecnico.entity.DirectorTecnico;
import com.example.directorTecnico.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JugadorRepository extends JpaRepository<Jugador,Long> {

}
