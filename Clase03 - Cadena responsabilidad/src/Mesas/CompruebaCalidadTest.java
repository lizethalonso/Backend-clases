package Mesas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompruebaCalidadTest {
    @Test
    public void crearArticulos(){
        //DADO
        AnalistaDeCalidad analistaDeCalidad = new AnalistaDeCalidad();
        Articulo articulo1 = new Articulo("Nihao",1200,1300,"sano");
        Articulo articulo2 = new Articulo("Ohaio",1000,1200,"sano");
        Articulo articulo3 = new Articulo("Hallo",1000,1250,"casi sano");
        Articulo articulo4 = new Articulo("Anniong",1250,1200,"sano");
        //CUANDO
        analistaDeCalidad.dispararCadena(articulo1);
        analistaDeCalidad.dispararCadena(articulo2);
        analistaDeCalidad.dispararCadena(articulo3);
        analistaDeCalidad.dispararCadena(articulo4);
        //ENTONCES
        String respEsperada = "Artículo aceptado";
        Assertions.assertEquals(respEsperada,articulo1.getEstado());
        Assertions.assertEquals(respEsperada,articulo2.getEstado());
        Assertions.assertEquals(respEsperada,articulo3.getEstado());
        Assertions.assertEquals(respEsperada,articulo4.getEstado());
    }
}
