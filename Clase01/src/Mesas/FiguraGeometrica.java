package Mesas;

import java.text.DecimalFormat;

public class FiguraGeometrica {
    private String nombre;


    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }


    public String calcularArea(Double radioLado){
        Double resArea;
        if (radioLado > 0){
            Double resAreaTemp;
            if (nombre.equals("Cuadrado")){
                resAreaTemp = radioLado * radioLado;
            }else if (nombre.equals("Circulo")){
                resAreaTemp = Math.PI * (radioLado*radioLado);
            }else{
                throw new IllegalArgumentException("El nombre de la figura debe ser Cuadrado o Circulo");
            }
            // Reduzco a 2 decimales
            resArea = Math.round(resAreaTemp*100.0)/100.0;
            return "El valor del área del " + nombre + " es " + resArea + " unidades";
        }else{
            throw new IllegalArgumentException("El valor del radio o lado debe ser mayor que 0");
        }
    }
}
