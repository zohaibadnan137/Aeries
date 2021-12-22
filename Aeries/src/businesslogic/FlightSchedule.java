package businesslogic;

import java.util.*;

public class FlightSchedule {
	private ArrayList<Flight> flights;
	
	public FlightSchedule()
	{
		flights = null;
	}
	public Flight addFlight(FlightPlan plan)
	{
		if(flights == null)
		{
			flights = new ArrayList<Flight>();
		}
		Flight newFlight = new Flight(plan);
		flights.add(newFlight);
		return newFlight;
	}
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	
}
