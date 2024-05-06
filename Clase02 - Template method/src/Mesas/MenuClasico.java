package Mesas;

public class MenuClasico extends Menu{

    public MenuClasico(Double precioBase) {
        super(precioBase);
    }

    @Override
    public Double calcularPrecio() {
        return getPrecioBase();
    }

    @Override
    public String armarMenu() {
        return "El menú clásico no incluye recargos adicionales y su precio final es de: "
                + getPrecioBase();
    }
}
