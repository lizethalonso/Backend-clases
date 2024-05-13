package PG;

public class Test {

    private static final String colores[] = {"Rojo", "Azul", "Verde", "Negro"};

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Circulo circulo = FlyweightFactory.obtenerCirculo(getRandomColor());
            circulo.setRadio(i + 5);
            circulo.setTamaño("Tamaño: " + i * 2);
            circulo.dibujar();
        }
    }

    private static String getRandomColor(){
        return colores[(int)(Math.random()*colores.length)];
    }
}
