package businesslogic;

import java.util.ArrayList;

//This is Aircraft Class
public class Aircraft {
	private AircraftDescription aircraftDescription;
	private String registrationNumber;
	private String status;
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
