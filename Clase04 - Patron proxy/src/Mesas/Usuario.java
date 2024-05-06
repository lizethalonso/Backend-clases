package Mesas;

public class Usuario {
    private String id;
    private Enum tipoUsuario;

    public Usuario(String id, Enum tipoUsuario) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
    }

    public String getId() {
        return id;
    }

    public Enum getTipoUsuario() {
        return tipoUsuario;
    }
}
