package Gomez_Alonso.ClinicaOdontologica.service;


import Gomez_Alonso.ClinicaOdontologica.dao.PacienteDAOH2;
import Gomez_Alonso.ClinicaOdontologica.dao.iDao;
import Gomez_Alonso.ClinicaOdontologica.model.Paciente;

public class PacienteService {
private iDao<Paciente> pacienteiDao;

    public PacienteService() {
        pacienteiDao=new PacienteDAOH2();
    }
    //metodos manuales
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPorID(Integer id){
        return pacienteiDao.buscarPorId(id);
    }
}
