package PG;

public abstract class Manejador {
    private Manejador siguienteManejador;
    private Integer acceso;


    public Manejador(Integer nivelAcceso) {
        this.acceso = nivelAcceso;
    }

    public Manejador getSiguienteManejador() {
        return siguienteManejador;
    }

    public void setSiguienteManejador(Manejador siguienteManejador) {
        this.siguienteManejador = siguienteManejador;
    }

    public Integer getAcceso() {
        return acceso;
    }

    public abstract String comprobarDocumento(Documento documento);
}
