package businesslogic;

import java.util.*;

import utilities.DateAndTime;

public class FlightPlanCatalog {
	private ArrayList<FlightPlan> flightPlans;
	
	public FlightPlanCatalog()
	{
		flightPlans = null;
	}
	
	public void addFlightPlan(String flightNumber, DateAndTime plannedDeparture, DateAndTime plannedArrival,Airport origin, Airport destination)
	{
		if(flightPlans == null)
		{
			flightPlans = new ArrayList<FlightPlan>();
		}
		flightPlans.add(new FlightPlan(flightNumber, plannedDeparture, plannedArrival, origin, destination));
	}
}
