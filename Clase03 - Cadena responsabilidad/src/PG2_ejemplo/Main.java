package PG2_ejemplo;

public class Main {

    public static void main(String[] args) {

        EmpleadoBanco manejadorBase = new EjecutivoCuenta().setSigEmpleadoBanco(new Gerente().setSigEmpleadoBanco(new Director()));

        manejadorBase.procesarSolicitud(78000);

    }
}
