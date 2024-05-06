package Mesas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServicioDescargaTest {

    @Test
    public void usuarioDescarga(){
        //DADO
        Usuario usuario1 = new Usuario("11111",TipoUsuario.tipo.premium);
        Usuario usuario2 = new Usuario("22222",TipoUsuario.tipo.premium);

        ServicioDescargaProxy centroDescarga = new ServicioDescargaProxy();

        //CUANDO
        String usu1 = centroDescarga.descargar(usuario1,"Tell me");
        String usu2 = centroDescarga.descargar(usuario2, "Irony");
        String respuestaEsp1 = "Estimado/a " + usuario1.getId() + " se está descargando la canción Tell me";
        String respuestaEsp2 = "Estimado/a " + usuario2.getId() + " se está descargando la canción Irony";

        //ENTONCES
        Assertions.assertEquals(respuestaEsp1,usu1);
        Assertions.assertEquals(respuestaEsp2,usu2);

    }
}
