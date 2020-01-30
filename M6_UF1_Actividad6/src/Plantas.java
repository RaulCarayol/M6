
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Plantas")
public class Plantas {
	private Planta[] planta;
	@XmlElement(name="Planta")
	public Planta[] getPlantas() {
		return planta;
	}

	public void setPlantas(Planta[] plantas) {
		this.planta = plantas;
	}
}
