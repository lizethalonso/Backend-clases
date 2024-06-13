package com.c3.orm.service;

import com.c3.orm.entity.Mascota;
import com.c3.orm.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    public Mascota guardarMascota(Mascota mascota){
        return mascotaRepository.save(mascota);
    }
    public List<Mascota> buscarTodasMascotas(){
        return mascotaRepository.findAll();
    }
    public Optional<Mascota> buscarMascotaPorId(Long id){
        return mascotaRepository.findById(id);
    }
    public Mascota actualizarMascota(Mascota mascota){
        return mascotaRepository.save(mascota);
    }
    public void eliminarMascota(Long id){
        mascotaRepository.deleteById(id);
    }

}
