package Mesas;

import java.util.Date;

public class Vuelo {

    private Date fechaSalida;
    private Date fechaRegreso;
    private String origen;
    private String destino;

    public Vuelo(Date fechaSalida, Date fechaRegreso, String origen, String destino) {
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.origen = origen;
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }
}
