package Mesas;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        ArbolFactory arbolFactory = new ArbolFactory();
        List<Arbol> listaArboles = new ArrayList<>();

        for (int i = 0; i < 500000; i++){
            listaArboles.add(arbolFactory.getArbol(200,400,"verde,","Ornamental"));
            listaArboles.add(arbolFactory.getArbol(500,300,"rojo,","frutal"));

//            System.out.println(fabricaArboles.getArbol("Ornamental"));
//            System.out.println(fabricaArboles.getArbol("Frutal"));
        }
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada:"  + (runtime.totalMemory() -
                runtime.freeMemory()) / (1024 * 1024) + "MB");
    }
}
