package businesslogic;

import java.util.ArrayList;

public class Fleet {
	ArrayList<Aircraft> aircrafts;
	
	public Fleet()
	{
		aircrafts=null;
	}
	public void addAircraft(Aircraft aircraft)
	{
		if(this.aircrafts == null)
		{
			this.aircrafts = new ArrayList<Aircraft>();
		}
		this.aircrafts.add(aircraft);
	}
	public Aircraft getAircraft(String registrationNumber)
	{
		for(Aircraft aircraft: aircrafts)
		{
			if(aircraft.getRegistrationNumber().equals(registrationNumber))
			{
				return aircraft;
			}
		}
		return null;
	}
	public boolean isAircraftAvailable(String registrationNumber)
	{
		Aircraft aircraft = this.getAircraft(registrationNumber);
		if(aircraft!=null)
		{
			String status = aircraft.getStatus();
			if(status.equals("Available"))
			{
				return true;
			}
			return false;
		}
		return false;
	}
	public Aircraft addAircraft(int registrationNumber, String status, AircraftDescription description)
	{
		Aircraft aircraft = new Aircraft(description, status, status);
		int seatNumber = 1;
		for(int i=0; i<30; i++)
		{
			String seatLocation="";
			if(i%2==0) {
				seatLocation="Window";
			}else
			{
				seatLocation="Aisle";
			}
			Seat seat = new Seat(seatNumber,"Economy",seatLocation,1);
			aircraft.addSeat(seat);
			seatNumber++;
		}
		for(int i=0; i<10; i++)
		{
			String seatLocation="";
			if(i%2==0) {
				seatLocation="Window";
			}else
			{
				seatLocation="Aisle";
			}
			Seat seat = new Seat(i,"Business",seatLocation,2);
			aircraft.addSeat(seat);
			seatNumber++;
		}
		return aircraft;
	}
}
