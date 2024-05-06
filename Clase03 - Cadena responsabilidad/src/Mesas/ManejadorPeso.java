package Mesas;

public class ManejadorPeso extends Manejador {

    @Override
    public void validarCalidadDelProducto(Articulo articulo) {
        if (articulo.getPeso()>=1200 && articulo.getPeso()<=1300){
            if (getSiguienteManejador()!=null){
                getSiguienteManejador().validarCalidadDelProducto(articulo);
            }
        }else {
            articulo.setEstado("Artículo rechazado por peso");
            //System.out.println("Artículo rechazado por peso");
        }
    }
}
