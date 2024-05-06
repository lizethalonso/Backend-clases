package Presencial;

public class Mail {
    private String origen, destino, asunto;

    public Mail(String origen, String destino, String asunto) {
        this.origen = origen;
        this.destino = destino;
        this.asunto = asunto;
    }

    public String getDestino() {
        return destino;
    }

    public String getAsunto() {
        return asunto;
    }
}
