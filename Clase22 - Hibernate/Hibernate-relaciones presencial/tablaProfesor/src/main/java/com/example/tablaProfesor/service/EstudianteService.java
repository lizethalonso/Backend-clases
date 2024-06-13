package com.example.tablaProfesor.service;

import com.example.tablaProfesor.entity.Estudiante;
import com.example.tablaProfesor.entity.Profesor;
import com.example.tablaProfesor.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante guardarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }
    public Estudiante actualizarEstudiante(Estudiante estudiante){ return estudianteRepository.save(estudiante); }
    public Optional<Estudiante> buscarPorId(Long id){ return estudianteRepository.findById(id); }
    public List<Estudiante> listarTodos(){
        return estudianteRepository.findAll();
    }
    public void eliminarEstudiante(Long id){
        estudianteRepository.deleteById(id);
    }
}
