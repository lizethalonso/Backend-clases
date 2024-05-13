package Mesas;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private Map<String,Arbol>arbolMap;
    private int contador=0;

    public ArbolFactory() {
        arbolMap = new HashMap<>();
    }

    public Arbol getArbol(int alto, int horizontal, String color, String tipoArbol){
        String key = "Arbol " + alto + horizontal + color + tipoArbol;
        if (!arbolMap.containsKey(key)){
            arbolMap.put(key,new Arbol(alto, horizontal, color,tipoArbol));
            System.out.println("Arbol creado con éxito");
        }
        contador++;
        System.out.println("Árboles utilizados: " + contador);
        return arbolMap.get(key);
    }
}
