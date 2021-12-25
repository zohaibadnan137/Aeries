package businesslogic;

import utilities.DateAndTime;
import javax.persistence.*;
@Entity
@Table(name="FlightPlan")
public class FlightPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="flightNumber")
	private String flightNumber; 
	@OneToOne(cascade= CascadeType.ALL)
	private DateAndTime plannedDeparture; 
	@OneToOne(cascade= CascadeType.ALL)
	private DateAndTime plannedArrival;
	@OneToOne(cascade= CascadeType.ALL)
	private Airport origin;
	@OneToOne(cascade= CascadeType.ALL)
	private Airport destination;

	public FlightPlan(String flightNumber, DateAndTime plannedDeparture, DateAndTime plannedArrival,Airport origin, Airport destination)
	{
		this.flightNumber=flightNumber;
		this.plannedDeparture = plannedDeparture; 
		this.plannedArrival = plannedArrival;
		this.origin = origin;
		this.destination = destination;
		PersistenceFactory.getHandler().save(this);
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
