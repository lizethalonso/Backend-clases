package Gomez_Alonso.ClinicaOdontologica.dao;


import Gomez_Alonso.ClinicaOdontologica.model.Odontologo;
import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
public class OdontologoDAOCollection implements iDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOCollection.class);
    private List<Odontologo> odontologos = new ArrayList<>();
    private int idCounter = 1;
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(idCounter++);
        odontologos.add(odontologo);
        logger.info("Odontólogo guardado en la colección: " + odontologo);
        return odontologo;
    }
    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Listado de todos los odontólogos recuperado de la colección.");
        return new ArrayList<>(odontologos);
    }

    @Override
    public Odontologo buscarPorString(String string) {
        return null;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null; //
    }
    @Override
    public void eliminar(Integer id) {
        //
    }
    @Override
    public void actualizar(Odontologo odontologo) {}

}
