package Mesas;

public class Main {
    public static void main(String[] args) {

        FiguraGeometrica figura1 = new FiguraGeometrica("Cuadrado");
        FiguraGeometrica figura2 = new FiguraGeometrica("Circulo");

        String mensajeFigura1 = figura1.calcularArea(1.8);
        String mensajeFigura2 = figura2.calcularArea(2.5);

        System.out.println(mensajeFigura1);
        System.out.println(mensajeFigura2);
    }
}

