package Mesas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> vacia = Arrays.asList();
        List<Integer> lista1 = Arrays.asList(1,2,3,4,5,6);
        List<Integer> lista2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);

        Numeros numeros1 = new Numeros(vacia);
        Numeros numeros2 = new Numeros(lista1);
        Numeros numeros3 = new Numeros(lista2);

        System.out.println("Promedio: "+ numeros1.calcularPromedio());
        System.out.println("Promedio: "+ numeros2.calcularPromedio());
        System.out.println("Promedio: "+ numeros3.calcularPromedio());
        System.out.println("----------------------------------------------------------------------------------------");

        System.out.println("Máximo: "+ numeros1.encontrarMaximo());
        System.out.println("Máximo: "+ numeros2.encontrarMaximo());
        System.out.println("Máximo: "+ numeros3.encontrarMaximo());
        System.out.println("----------------------------------------------------------------------------------------");

        System.out.println("Mínimo: "+ numeros1.encontrarMinimo());
        System.out.println("Mínimo: "+ numeros2.encontrarMinimo());
        System.out.println("Mínimo: "+ numeros3.encontrarMinimo());
        System.out.println("----------------------------------------------------------------------------------------");
    }
}
