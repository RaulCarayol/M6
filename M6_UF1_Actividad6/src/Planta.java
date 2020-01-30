
public class Planta {
	 private String common;
	 private String botanical;
	 private int zone; 
	 private String light;
	 private String price;
	 private int availability;
	public Planta(String common, String botanical, int zone, String light,
			String price, int availability) {
		this.common = common;
		this.botanical = botanical;
		this.zone = zone;
		this.light = light;
		this.price = price;
		this.availability = availability;
	}
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	public String getBotanical() {
		return botanical;
	}
	public void setBotanical(String botanical) {
		this.botanical = botanical;
	}
	public int getZone() {
		return zone;
	}
	public void setZone(int zone) {
		this.zone = zone;
	}
	public String getLight() {
		return light;
	}
	public void setLight(String light) {
		this.light = light;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	 
	 
}
