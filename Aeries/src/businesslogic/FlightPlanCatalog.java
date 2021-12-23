package businesslogic;

import java.util.*;

import utilities.DateAndTime;

public class FlightPlanCatalog {
	private ArrayList<FlightPlan> flightPlans;
	
	public FlightPlanCatalog()
	{
		flightPlans = null;
	}
	
	public FlightPlan addFlightPlan(String flightNumber, DateAndTime plannedDeparture, DateAndTime plannedArrival,Airport origin, Airport destination)
	{
		if(flightPlans == null)
		{
			flightPlans = new ArrayList<FlightPlan>();
		}
		FlightPlan newFlight = new FlightPlan(flightNumber, plannedDeparture, plannedArrival, origin, destination);
		flightPlans.add(newFlight);
		return newFlight;
	}

	public ArrayList<FlightPlan> getFlightPlans() {
		return flightPlans;
	}
	public FlightPlan getFlightPlan(String flightNumber)
	{
		for(FlightPlan flightPlan: flightPlans)
		{
			if(flightPlan.getFlightNumber().equals(flightNumber))
			{
				return flightPlan;
			}
		}
		return null;
	}
	
}
