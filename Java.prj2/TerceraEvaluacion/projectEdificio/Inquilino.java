package projectEdificio;

import java.io.Serializable;

public class Inquilino implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
    private String apellido;
    private String dni;
    //Constructor de los Inquilinos
    public Inquilino(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    //Setter's y Getter's
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    //Muestra toda la informacion del Inquilino
    @Override
    public String toString() {
        return String.format("|                     %-14s %-15s %s         |%n"
        					, nombre, apellido, dni);
    }
}
