package Gomez_Alonso.ClinicaOdontologica.dao;

import Gomez_Alonso.ClinicaOdontologica.model.Domicilio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DomicilioDAOH2Test {
    DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

    @Test
    void testGuardar() {
        Domicilio expected = new Domicilio(37, "calle", 0, "localidad", "provincia");
        Domicilio result = domicilioDAOH2.guardar(expected);

        // Comparar atributos individualmente
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.getId(), result.getId());
        Assertions.assertEquals(expected.getCalle(), result.getCalle());
        Assertions.assertEquals(expected.getNumero(), result.getNumero());
        Assertions.assertEquals(expected.getLocalidad(), result.getLocalidad());
        Assertions.assertEquals(expected.getProvincia(), result.getProvincia());
    }

    @Test
    void testBuscarPorId() {
        Domicilio expected = new Domicilio(37, "calle", 0, "localidad", "provincia");
        Domicilio result = domicilioDAOH2.buscarPorId(37);

        // Comparar atributos individualmente
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.getId(), result.getId());
        Assertions.assertEquals(expected.getCalle(), result.getCalle());
        Assertions.assertEquals(expected.getNumero(), result.getNumero());
        Assertions.assertEquals(expected.getLocalidad(), result.getLocalidad());
        Assertions.assertEquals(expected.getProvincia(), result.getProvincia());
    }

    @Test
    void testEliminar() {
        int id = 37;

        // Agregar un domicilio para la prueba
        Domicilio domicilio = new Domicilio(id, "calle", 0, "localidad", "provincia");
        domicilioDAOH2.guardar(domicilio);

        // Verificar que el domicilio existe antes de eliminarlo
        Domicilio domicilioExistente = domicilioDAOH2.buscarPorId(id);
        Assertions.assertNotNull(domicilioExistente);

        // Llamar al método eliminar
        domicilioDAOH2.eliminar(id);

        // Verificar que el domicilio ya no existe después de eliminarlo
        Domicilio domicilioEliminado = domicilioDAOH2.buscarPorId(id);
        Assertions.assertNull(domicilioEliminado);
    }

    @Test
    void testActualizar() {
        domicilioDAOH2.actualizar(new Domicilio(Integer.valueOf(0), "calle", Integer.valueOf(0), "localidad", "provincia"));
    }

    @Test
    void testBuscarTodos() {
       }

    @Test
    void testBuscarPorString() {
        }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme