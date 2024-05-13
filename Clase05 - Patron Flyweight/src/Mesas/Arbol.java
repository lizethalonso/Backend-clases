package Mesas;

public class Arbol {
    private int alto;
    private int horizontal;
    private String color;
    private String tipoArbol;
    private static int contador=0;

    public Arbol(int alto, int horizontal, String color, String tipoArbol) {
        this.alto = alto;
        this.horizontal = horizontal;
        this.color = color;
        this.tipoArbol = tipoArbol;
        contador++;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoArbol() {
        return tipoArbol;
    }

    public void setTipoArbol(String tipoArbol) {
        this.tipoArbol = tipoArbol;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Arbol.contador = contador;
    }
}
