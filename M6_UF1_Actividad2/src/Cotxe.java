
public class Cotxe {
	private String marca, model,matricula;
	private int any;
	public Cotxe(String marca, String model,String matricula, int any){
		this.any = any;
		this.marca = marca;
		this.matricula = matricula;
		this.model = model;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getAny() {
		return any;
	}
	public void setAny(int any) {
		this.any = any;
	}
	
}
