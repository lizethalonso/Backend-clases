package Mesas;

public class MenuVegetariano extends Menu{

    private int cantidadSalsas;
    private boolean tieneEspecias;

    public MenuVegetariano(Double precioBase, int cantidadSalsas, boolean tieneEspecias) {
        super(precioBase);
        this.cantidadSalsas = cantidadSalsas;
        this.tieneEspecias = tieneEspecias;
    }

    @Override
    public Double calcularPrecio() {
        double precioFinal = getPrecioBase();
        if (tieneEspecias){
            precioFinal = getPrecioBase() + getPrecioBase()*0.01;
        }
        if (cantidadSalsas>0){
            precioFinal = precioFinal + cantidadSalsas * 2;
        }

        return precioFinal;
    }

    @Override
    public String armarMenu() {
        if (cantidadSalsas>0 && tieneEspecias){
            return "El menú vegetariano tiene " + cantidadSalsas + " salsas"
                    + " y especias con un precio de: " + calcularPrecio();
        } else if (cantidadSalsas == 0 && tieneEspecias){
            return "El menú vegetariano tiene especias con un precio de: " +
                    calcularPrecio();
        } else if (cantidadSalsas > 0 && !tieneEspecias) {
            return "El menú vegetariano tiene " + cantidadSalsas + " salsas con " +
                    "un precio de: " + calcularPrecio();
        } else {
            return "El menú vegetariano no contiene adicionales y su precio final" +
                    "es de: " + calcularPrecio();
        }

    }
}
