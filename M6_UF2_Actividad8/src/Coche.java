
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Coche implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Id @GeneratedValue
    private long id;
    
    private String nombre;
    private String marca;
    private int años;
    private int cV; //caballos Cubicos 
    private Persona propietario;
    private boolean reparado; 
    
    public Coche(){
    	
    }
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAños() {
		return años;
	}
	public void setAños(int años) {
		this.años = años;
	}
	public int getcV() {
		return cV;
	}
	public void setcV(int cV) {
		this.cV = cV;
	}
	public Persona getPropietario() {
		return propietario;
	}
	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
	
	public boolean isReparado() {
		return reparado;
	}
	public void setReparado(boolean reparado) {
		this.reparado = reparado;
	}
	
	@Override
	public String toString() {
		return "Coche [id=" + id + ", nombre=" + nombre + ", marca=" + marca
				+ ", años=" + años + ", cV=" + cV + ", propietario="
				+ propietario + "]";
	}
    
    
}
