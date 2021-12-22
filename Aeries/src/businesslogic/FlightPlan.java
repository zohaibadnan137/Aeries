package businesslogic;

import utilities.DateAndTime;

public class FlightPlan {
	private String flightNumber; 
	private DateAndTime plannedDeparture; 
	private DateAndTime plannedArrival;
	private Airport origin;
	private Airport destination;

	public FlightPlan(String flightNumber, DateAndTime plannedDeparture, DateAndTime plannedArrival,Airport origin, Airport destination)
	{
		this.flightNumber=flightNumber;
		this.plannedDeparture = plannedDeparture; 
		this.plannedArrival = plannedArrival;
		this.origin = origin;
		this.destination = destination;
	}
	public DateAndTime getPlannedDepartureTime() {
		return plannedDeparture;
	}
	public DateAndTime getPlannedArrivalTime() {
		return plannedArrival;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Airport getOrigin() {
		return origin;
	}
	public void setOrigin(Airport origin) {
		this.origin = origin;
	}
	public Airport getDestination() {
		return destination;
	}
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
}
