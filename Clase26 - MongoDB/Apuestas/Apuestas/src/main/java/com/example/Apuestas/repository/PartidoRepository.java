package com.example.Apuestas.repository;

import com.example.Apuestas.entity.Estado;
import com.example.Apuestas.entity.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PartidoRepository extends MongoRepository<Partido,Long> {
    //aca van todas las consultas HQL manuales que pudieran generar
    //@Query("SELECT p FROM Partido p WHERE p.estado=?1")
    List<Partido> findPartidoByEstado(Estado estado);
}
