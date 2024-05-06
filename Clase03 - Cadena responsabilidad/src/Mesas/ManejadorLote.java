package Mesas;

public class ManejadorLote extends Manejador {

    @Override
    public void validarCalidadDelProducto(Articulo articulo) {
        if (articulo.getLote()>=1000 && articulo.getLote()<=2000){
            getSiguienteManejador().validarCalidadDelProducto(articulo);
        }else {
            articulo.setEstado("Artículo rechazado por lote");
            //System.out.println("Artículo rechazado por lote");
        }
    }
}
