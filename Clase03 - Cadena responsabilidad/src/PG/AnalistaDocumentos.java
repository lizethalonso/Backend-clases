package PG;

public class AnalistaDocumentos {
    Manejador inicial = new ManejadorDiputado(1);
    public AnalistaDocumentos() {
        Manejador ministro = new ManejadorMinistro(2);
        Manejador presidente = new ManejadorPresidente(3);

        inicial.setSiguienteManejador(ministro);
        ministro.setSiguienteManejador(presidente);

    }
    public String dispararCadena(Documento documento){
        return inicial.comprobarDocumento(documento);
    }




}
