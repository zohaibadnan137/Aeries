package businesslogic;

public class AircraftDescription {
	private String manufacturer;
	private String model;
	private int seatingCapacity;
	
	public AircraftDescription(String manufacturer, String model, int seatingCapacity)
	{
		this.manufacturer = manufacturer;
		this.model = model;
		this.seatingCapacity = seatingCapacity;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
}
