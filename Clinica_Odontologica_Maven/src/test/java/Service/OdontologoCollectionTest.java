package Service;


import org.example.dao.OdontologoDAOCollection;
import org.example.model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OdontologoCollectionTest {
    @Test
    public void listarOdontologos() {
        OdontologoDAOCollection odontoColl = new OdontologoDAOCollection();
        Odontologo odontologo1 = new Odontologo(1,"12345", "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(2,"67890", "Ana", "Lopez");
        odontoColl.guardar(odontologo1);
        odontoColl.guardar(odontologo2);

        List<Odontologo> odontologos = odontoColl.buscarTodos();
        Assertions.assertEquals(2, odontologos.size());
    }
}
