package PG;


import java.util.List;

public class EnvioService {

    public void procesarEnvio(List<Producto> productos, Direccion direccion){
        System.out.println("Enviando productos a " + direccion.getCalle() +" "+ direccion.getNro() +","+ direccion.getBarrio());
    }
}
