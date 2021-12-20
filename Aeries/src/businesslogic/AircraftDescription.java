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
}
