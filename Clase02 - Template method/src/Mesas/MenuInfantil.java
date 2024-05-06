package Mesas;

public class MenuInfantil extends Menu{

    private int cantidadJuguetes;

    public MenuInfantil(Double precioBase, int cantidadJuguetes) {
        super(precioBase);
        this.cantidadJuguetes = cantidadJuguetes;
    }

    @Override
    public Double calcularPrecio() {
        return getPrecioBase() + (cantidadJuguetes*3);
    }

    @Override
    public String armarMenu() {
        return "El menú infantil incluye " + cantidadJuguetes +
                " de juguetes con un valor final de: " + calcularPrecio();
    }
}
