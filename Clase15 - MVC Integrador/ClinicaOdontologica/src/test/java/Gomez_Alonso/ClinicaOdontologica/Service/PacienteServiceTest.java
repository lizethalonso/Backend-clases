package Gomez_Alonso.ClinicaOdontologica.Service;

import org.example.dao.BD;
import org.example.model.Paciente;
import org.example.service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PacienteServiceTest {
    @Test
    public void buscarPacientePorID(){
        BD.crearTablas();
        PacienteService pacienteService= new PacienteService();
        Integer id=2;
        Paciente paciente= pacienteService.buscarPorID(id);
        Assertions.assertTrue(paciente!=null);
    }
}
