package PG;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompruebaDocumentoTest {
    @Test
    public void analisisDeDocumentos(){
        AnalistaDocumentos analista = new AnalistaDocumentos();
        Documento documento1 = new Documento("Nihao",1);
        Documento documento2 = new Documento("Nihao",2);
        Documento documento3 = new Documento("Nihao",3);
        String respuestaEsp = "Descargando documento para leer";
        String resEspPres = "Sr. Presidente. Estamos descargando el documento...";

        String respuesta1 = analista.dispararCadena(documento1);
        String respuesta2 = analista.dispararCadena(documento2);
        String respuesta3 = analista.dispararCadena(documento3);


        Assertions.assertEquals(respuestaEsp, respuesta1);
        Assertions.assertEquals(respuestaEsp, respuesta2);
        Assertions.assertEquals(respuestaEsp, respuesta3);
    }
}
