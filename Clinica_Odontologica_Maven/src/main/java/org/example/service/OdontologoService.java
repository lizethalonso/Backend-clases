package org.example.service;


import org.example.dao.OdontologoDAOH2;
import org.example.dao.iDao;
import org.example.model.Odontologo;


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

    public List<Odontologo> buscarTodos(){
        return odontologoiDao.buscarTodos();
    }

}
