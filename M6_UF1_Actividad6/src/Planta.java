
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "PLANT")
@XmlType(propOrder = {"common", "botanical", "zone", "light", "price","availability"})
public class Planta {
	 private String common;
	 private String botanical;
	 private int zone; 
	 private String light;
	 private String price;
	 private int availability;
	 
	 @XmlElement
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	@XmlElement
	public String getBotanical() {
		return botanical;
	}
	public void setBotanical(String botanical) {
		this.botanical = botanical;
	}
	@XmlElement
	public int getZone() {
		return zone;
	}
	public void setZone(int zone) {
		this.zone = zone;
	}
	@XmlElement
	public String getLight() {
		return light;
	}
	public void setLight(String light) {
		this.light = light;
	}
	@XmlElement
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@XmlElement
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
}
