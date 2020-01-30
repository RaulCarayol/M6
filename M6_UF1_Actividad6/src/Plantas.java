
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Plantas {
	private Planta[] planta;

	public Planta[] getPlantas() {
		return planta;
	}

	public void setPlantas(Planta[] plantas) {
		this.planta = plantas;
	}
}
