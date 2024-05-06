package Mesas;

public class ManejadorEnvase extends Manejador {

    @Override
    public void validarCalidadDelProducto(Articulo articulo) {
        if (articulo.getEnvase().equalsIgnoreCase("sano")||articulo.getEnvase().equalsIgnoreCase("casi sano")){
            if (getSiguienteManejador() != null) {
                getSiguienteManejador().validarCalidadDelProducto(articulo);
            }
        }else{
            articulo.setEstado("Artículo rechazado por envase");
            //System.out.println("Artículo rechazado por envase");
        }
    }
}
