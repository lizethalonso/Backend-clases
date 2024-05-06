package Mesas;

public class ManejadorAceptado extends Manejador {

    @Override
    public void validarCalidadDelProducto(Articulo articulo) {
        articulo.setEstado("Artículo aceptado");
        //System.out.println("Artículo aceptado");
    }
}
