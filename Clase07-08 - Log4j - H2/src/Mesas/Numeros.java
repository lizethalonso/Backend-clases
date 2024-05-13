package Mesas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Numeros {
    List<Integer> listaNumeros;
    private static final Logger logger = LogManager.getLogger("infoLogger");

    public Numeros(List<Integer> listaNumeros) {
        this.listaNumeros = listaNumeros;
    }

    public boolean loggerListSize() {
        if (listaNumeros.size() > 10) {
            logger.info("La longitud de la lista es mayor a 10");
        } else if (listaNumeros.size() > 5) {
            logger.info("La longitud de la lista es mayor a 5");
        } else if (listaNumeros.isEmpty()) {
            logger.error("La lista es igual a 0");
        } else {
            return false;
        }
        return true;
    }//si cualquier if se cumple retorna true, caso contrario retorna false

    public Double calcularPromedio() {
        loggerListSize();
        try {
            if (!listaNumeros.isEmpty()) {
                double suma = 0.0;
                for (Integer numero : listaNumeros) {
                    suma += numero;
                }
                return suma / listaNumeros.size();
            } throw new RuntimeException("No se puede promediar una lista vacía");
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
            return null; // Valor de retorno específico para indicar que ocurrió un error
        }
    }

    public Integer encontrarMaximo () {
        loggerListSize();
        try {
            if (!listaNumeros.isEmpty()){
                Integer maximo = 0;
                for (Integer numero : listaNumeros) {
                    if (numero > maximo) {
                        maximo = numero;
                    }
                }return maximo;
            } throw new RuntimeException("No se puede encontrar el máximo de una lista vacía");
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Integer encontrarMinimo () {
        loggerListSize();
        try {
            if (!listaNumeros.isEmpty()) {
                Integer minimo = 100000000;
                for (Integer numero : listaNumeros) {
                    if (numero < minimo) {
                        minimo = numero;
                    }
                }return minimo;
            }throw new RuntimeException("No se puede encontrar el mínimo de una lista vacía");
        }catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
}

