package Mesas;

public class AnalistaDeCalidad {
    // Se encarga de dirigir a quién le va pasando la cadena
    // de responsabilidad
    Manejador inicial = new ManejadorLote();

    public AnalistaDeCalidad() {
        Manejador peso = new ManejadorPeso();
        Manejador envase = new ManejadorEnvase();
        Manejador aceptado = new ManejadorAceptado();

        inicial.setSiguienteManejador(peso);
        peso.setSiguienteManejador(envase);
        envase.setSiguienteManejador(aceptado);
    }

    public void dispararCadena(Articulo articulo){
        inicial.validarCalidadDelProducto(articulo);
    }
}
