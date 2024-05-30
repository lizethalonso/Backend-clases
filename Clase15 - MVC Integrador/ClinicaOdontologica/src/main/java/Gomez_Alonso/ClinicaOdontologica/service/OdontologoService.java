package Gomez_Alonso.ClinicaOdontologica.service;


import Gomez_Alonso.ClinicaOdontologica.dao.OdontologoDAOH2;
import Gomez_Alonso.ClinicaOdontologica.dao.iDao;
import Gomez_Alonso.ClinicaOdontologica.model.Odontologo;
import Gomez_Alonso.ClinicaOdontologica.model.Paciente;

import java.util.List;

public class OdontologoService {

    private iDao<Odontologo> odontologoiDao;

    public OdontologoService() {
        odontologoiDao = new OdontologoDAOH2();
    }
    //metodos manuales

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }

    public Odontologo buscarPorID(Integer id) {
        return odontologoiDao.buscarPorId(id);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoiDao.buscarTodos();
    }

    public void eliminarOdontologo(Integer id) {
        odontologoiDao.eliminar(id);
    }

    public void actualizarOdontologo(Odontologo odontologo) {
        odontologoiDao.actualizar(odontologo);
    }

    public Odontologo buscarPorMatricula(String matricula) {
        return odontologoiDao.buscarPorString(matricula);
    }

}
