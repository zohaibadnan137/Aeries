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
	public Flight getFlight(String flightNumber)
	{
		Flight retFlight=null;
		for(Flight flight: flights)
		{
			if(flight.getPlan().getFlightNumber().equals(flightNumber))
			{
				retFlight=flight;
			}
		}
		return retFlight;
	}
	public String getFlightStatus(String flightNumber)
	{
		Flight f = this.getFlight(flightNumber);
		return f.getStatus();
	}
	public ArrayList<Flight> searchFlight(Airport origin, Airport desination)
	{
		ArrayList<Flight> searchResults = new ArrayList<Flight>();
		for(Flight flight: this.flights)
		{
			if(flight.getPlan().getOrigin().getCode().equals(origin.getCode()) && flight.getPlan().getDestination().getCode().equals(desination.getCode()))
			{
				searchResults.add(flight);
			}
		}
			return searchResults;
	}
	public boolean bookTicket(Flight flight,ArrayList<Passenger> passengers)
	{
		Flight flightToBook = this.getFlight(flight.getPlan().getFlightNumber());
		return false;
	}
}
