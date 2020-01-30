
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Plantas {
	private Planta[] plantas;
	

	public Planta[] getPlantas() {
		return plantas;
	}

	public void setPlantas(Planta[] plantas) {
		this.plantas = plantas;
	}
}
