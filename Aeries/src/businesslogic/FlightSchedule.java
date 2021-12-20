package businesslogic;

import java.util.*;

public class FlightSchedule {
	private ArrayList<Flight> flights;
	
	public FlightSchedule()
	{
		flights = null;
	}
	public void addFlight(FlightPlan plan)
	{
		if(flights == null)
		{
			flights = new ArrayList<Flight>();
		}
		flights.add(new Flight(plan));
	}
}
