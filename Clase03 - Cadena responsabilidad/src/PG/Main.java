package PG;

public class Main {
    public static void main(String[] args) {

        AnalistaDocumentos analista = new AnalistaDocumentos();

        Documento documento1 = new Documento("Nihao",1);
        Documento documento2 = new Documento("Ohaio",2);
        Documento documento3 = new Documento("Anniong",3);
        String respuestaEsp = "Descargando documento para leer";
        String resEspPres = "Sr. Presidente. Estamos descargando el documento...";

        String respuesta1 = analista.dispararCadena(documento1);
        String respuesta2 = analista.dispararCadena(documento2);
        String respuesta3 = analista.dispararCadena(documento3);
    }
}
