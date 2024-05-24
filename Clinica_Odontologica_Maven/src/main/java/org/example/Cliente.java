package org.example;

import org.example.dao.BD;
import org.example.model.Odontologo;
import org.example.model.Paciente;
import org.example.model.Domicilio;
import org.example.service.OdontologoService;
import org.example.service.PacienteService;

import java.time.LocalDate;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        BD.crearTablas();
        //Buscar por ID paciente
        Paciente paciente= new Paciente("Luisa","Toro","111111", LocalDate.of(2024,5,21),new Domicilio("calle falsa",123,"cali","Colombia"));
        PacienteService pacienteService= new PacienteService();
        pacienteService.guardarPaciente(paciente);

        System.out.println("Paciente encontrado: "+pacienteService.buscarPorID(8));

        // Listar odontologos

        OdontologoService odontologoService = new OdontologoService();
        Odontologo odontologo1 = new Odontologo(1,"12345", "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(2,"67890", "Ana", "Lopez");
        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);
        List<Odontologo> odontologos = odontologoService.buscarTodos();

        System.out.println("Odontologos: ");
        for (Odontologo odontologo : odontologos) {
            System.out.println(odontologo.toString());
        }
    }
}
