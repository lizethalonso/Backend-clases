package PG;

public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;

    public Persona(String nombre, String apellido, String email, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
    }

    public String mostrarNombre(){
        return apellido + ", " + nombre;
    }

    public Boolean esMayor18(){
        return edad >= 18;
    }
}
