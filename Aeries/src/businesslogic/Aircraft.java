package businesslogic;

import java.util.ArrayList;
import javax.persistence.*;

//This is Aircraft Class
@Entity
@Table(name="Aircraft")
public class Aircraft {
	@OneToOne(cascade = CascadeType.ALL)
	private AircraftDescription aircraftDescription;
	@Id
	@Column(name="registrationNumber")
	private String registrationNumber;
	@Column(name="status")
	private String status;
	@OneToMany(cascade = CascadeType.ALL)
	private ArrayList<Seat> seats;
	
	public Aircraft(AircraftDescription aircraftDescription, String registrationNumber, String status)
	{
		seats = new ArrayList<Seat>();
		this.aircraftDescription = aircraftDescription;
		this.registrationNumber = registrationNumber;
		this.status = status;
	}
	public AircraftDescription getAircraftDescription() {
		return aircraftDescription;
	}
	public void setAircraftDescription(AircraftDescription aircraftDescription) {
		this.aircraftDescription = aircraftDescription;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<Seat> getSeats() {
		return seats;
	}
	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	public void addSeat(Seat seat)
	{
		if(seats==null)
		{
			this.seats = new ArrayList<Seat>();
		}
		seats.add(seat);
	}
	public ArrayList<Seat> getAvailableSeats()
	{
		ArrayList<Seat> availableSeats = new ArrayList<Seat>();
		for(Seat seat : this.seats)
		{
			if(seat.getStatus().equals("Available"))
			{
				availableSeats.add(seat);
			}
		}
		return availableSeats;
	}
}
