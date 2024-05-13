package Mesas;

import java.time.LocalDate;
import java.util.Date;

public class Hotel {
    private LocalDate fechaEntrada;
    private Date fechaSalida;
    private String ciudad;

    public Hotel(LocalDate fechaEntrada, Date fechaSalida, String ciudad) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.ciudad = ciudad;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public String getCiudad() {
        return ciudad;
    }
}
