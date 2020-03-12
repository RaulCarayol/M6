import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Id @GeneratedValue
    private long id;
    
    private String nombre;
    private String apellidos;
    private boolean casado;
    private int edad;
    private int dni;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public boolean isCasado() {
		return casado;
	}
	public void setCasado(boolean casado) {
		this.casado = casado;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", casado=" + casado + ", edad=" + edad + "]";
	}
    
    
}
