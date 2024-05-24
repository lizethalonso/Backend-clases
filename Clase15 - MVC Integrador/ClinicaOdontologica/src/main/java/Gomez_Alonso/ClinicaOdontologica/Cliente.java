package Gomez_Alonso.ClinicaOdontologica;

import Gomez_Alonso.ClinicaOdontologica.dao.BD;
import Gomez_Alonso.ClinicaOdontologica.model.Domicilio;
import Gomez_Alonso.ClinicaOdontologica.model.Odontologo;
import Gomez_Alonso.ClinicaOdontologica.model.Paciente;
import Gomez_Alonso.ClinicaOdontologica.service.OdontologoService;
import Gomez_Alonso.ClinicaOdontologica.service.PacienteService;

import java.time.LocalDate;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        BD.crearTablas();
        //Buscar por ID paciente
        Paciente paciente= new Paciente("Luisa","Toro","111111", LocalDate.of(2024,5,21),new Domicilio("calle falsa",123,"cali","Colombia"),"luisa@email.com");
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
