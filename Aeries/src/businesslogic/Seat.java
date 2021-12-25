package businesslogic;
import javax.persistence.*;

@Entity
@Table(name="Seat")
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="status")
	private String status;
	@Column (name="seatNumber")
	private int seatNumber;
	@Column(name="seatType")
	private String seatType;
	@Column(name="seatLocation")
	private String seatLocation;
	@Column(name="priceMultiplier")
	private int priceMultiplier;
	
	public Seat(int seatNumber, String seatType, String seatLocation,int priceMultiplier) {
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.seatLocation = seatLocation;
		this.status = "Available";
		this.priceMultiplier = priceMultiplier;
		PersistenceFactory.getHandler().save(this);
	}
	
	public String getType() {
		return this.seatType;
	}
	public String getLocation() {
		return this.seatLocation;
	}
	public String toString() {
		return "Seat Number: "+this.seatNumber+"\n"
				+"Seat Type: "+this.seatType+"\n"
				+"Seat Location: "+this.seatLocation+"\n"
				+"\n";
		
	}
	public String getStatus() {
		return this.status;
	}
	public void bookSeat() {
		this.status = "Reserved";
	}
	public void unBookSeat() {
		this.status = "Available";
	}
	public int getPriceMultiplier()
	{
		return this.priceMultiplier;
	}
	public void setPriceMultiplier(int multiplier)
	{
		this.priceMultiplier = multiplier;
	}
}