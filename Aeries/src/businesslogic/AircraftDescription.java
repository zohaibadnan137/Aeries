package businesslogic;
import javax.persistence.*;
@Entity
@Table(name="AircraftDescription")
public class AircraftDescription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="manufacturer")
	private String manufacturer;
	@Column(name="model")
	private String model;
	@Column(name="seatingCapacity")
	private int seatingCapacity;
	
	public AircraftDescription(String manufacturer, String model)
	{ 
		this.manufacturer = manufacturer;
		this.model = model;
		this.seatingCapacity = 40;
		PersistenceFactory.getHandler().save(this);
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
