package PG;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsPersona {
    @Test
    public void crearPersona(){
        //DADO
        Persona persona1 = new Persona("Valentina","Espejo","vale@mail.com",18);
        Persona persona2 = new Persona("Vincenzo","Calligari","vince@mail.com",39);
        Persona persona3 = new Persona("Aurora","Medina","aurora@mail.com",16);
        Persona persona4 = new Persona("Temo","Kang","temo@mail.com",18);
        //CUANDO
        persona1.mostrarNombre();

        persona1.esMayor18();
        persona2.esMayor18();
        persona3.esMayor18();
        persona4.esMayor18();
        //ENTONCES
        Assertions.assertEquals("Espejo, Valentina",persona1.mostrarNombre());

        Assertions.assertTrue(persona1.esMayor18());
        Assertions.assertTrue(persona2.esMayor18());
        Assertions.assertTrue(persona3.esMayor18());
        Assertions.assertTrue(persona4.esMayor18());
    }
}
