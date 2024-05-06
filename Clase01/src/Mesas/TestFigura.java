package Mesas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFigura {
    @Test

    public void crearFigurita(){
        //DADO
        FiguraGeometrica figura1 = new FiguraGeometrica("Cuadrado");
        FiguraGeometrica figura2 = new FiguraGeometrica("Circulo");
        //CUANDO
        String mensajeFigura1 = figura1.calcularArea(1.8);
        String mensajeFigura2 = figura2.calcularArea(2.5);
        //ENTONCES
        Assertions.assertEquals("El valor del área del Cuadrado es 3.24 unidades", mensajeFigura1);
        Assertions.assertEquals("El valor del área del Circulo es 19.63 unidades", mensajeFigura2);
    }



}
