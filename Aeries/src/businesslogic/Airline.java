package businesslogic;

import utilities.DateAndTime;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import Threads.*;
public class Airline {
	private String name;
	private EmployeeList employeeList;
	private ComplaintList complaintList;
	private FlightPlanCatalog flightPlanCatalog;
	private FlightSchedule flightSchedule;
	private Fleet fleet;

	public Airline(String name,EmployeeList employeeList,ComplaintList complaintList,FlightPlanCatalog flightPlanCatalog, FlightSchedule flightSchedule, Fleet fleet) {
		this.name = name;
		this.employeeList = employeeList;
		this.complaintList = complaintList;
		this.flightPlanCatalog = flightPlanCatalog;
		this.flightSchedule = flightSchedule;
		this.fleet = fleet;
		//PersistenceFactory.getHandler().save(this);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EmployeeList getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(EmployeeList employeeList) {
		this.employeeList = employeeList;
	}
	public FlightPlanCatalog getFlightPlanCatalog() {
		return flightPlanCatalog;
	}
	public void setFlightPlanCatalog(FlightPlanCatalog flightPlanCatalog) {
		this.flightPlanCatalog = flightPlanCatalog;
	}
	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}
	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}
	public Fleet getFleet() {
		return fleet;
	}
	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}
	public void setComplaintList(ComplaintList complaintList) {
		this.complaintList = complaintList;
	}
	
	public Employee authenticateUser(String email,String password)
	{
		return employeeList.authenticateUser(email, password);
	}
	public void fileComplaint(String description, BoardingPass boardingPass) throws FileNotFoundException, IOException
	{
		complaintList.addComplaint(description, boardingPass);
	}
	public ComplaintList getComplaintList()
	{
		return this.complaintList;
	}
	public ArrayList<FlightPlan> getAllFlightPlans()
	{
		return flightPlanCatalog.getFlightPlans();
	}
	public ArrayList<Flight> getAllScheduledFlights()
	{
		return flightSchedule.getFlights();
	}
	public FlightPlan addFlightPlan(String flightNumber, DateAndTime plannedDeparture, DateAndTime plannedArrival,Airport origin, Airport destination)
	{
		if(flightPlanCatalog==null)
		{
			flightPlanCatalog=new FlightPlanCatalog();
		}
		return flightPlanCatalog.addFlightPlan(flightNumber, plannedDeparture, plannedArrival, origin, destination);
	}
	
//Aircraft Functions
	public Aircraft addAircraft(int registrationNumber, String status, AircraftDescription description)
	{
		if(this.fleet==null)
		{
			this.fleet = new Fleet();
		}
		return this.fleet.addAircraft(registrationNumber,status,description);
	}
	public Aircraft getAircraft(String registrationNumber)
	{
		return this.fleet.getAircraft(registrationNumber);
	}
	public boolean isAircraftAvailable(String registrationNumber)
	{
		return this.fleet.isAircraftAvailable(registrationNumber);
	}
	public void unBookAircraft(Aircraft aircraft)
	{
		UnBookAircraftThread thread= new UnBookAircraftThread(aircraft);
		thread.start();
	}
	//Get flightPlan with a flightNumber
	public FlightPlan getFlightPlan(String flightNumber)
	{
		return this.flightPlanCatalog.getFlightPlan(flightNumber);
	}
	public Flight addNewFlight(FlightPlan flightPlan,int price, Aircraft aircraft) throws FileNotFoundException, IOException
	{
		if(this.flightSchedule==null)
		{
			this.flightSchedule = new FlightSchedule();
		}
		return flightSchedule.addFlight(flightPlan, price, aircraft);
	}
	public String checkFlightStatus(String flightNumber)
	{
		return flightSchedule.getFlightStatus(flightNumber);
	}
	public ArrayList<Flight> searchFlight(Airport origin, Airport destination)
	{
		return flightSchedule.searchFlight(origin, destination);
	}
	public Ticket bookTicket(Flight flight,ArrayList<Passenger> passengers,int amountPaid) throws FileNotFoundException, IOException
	{
		return flightSchedule.bookTicket(flight, passengers, amountPaid);
	}
	public void cancelTicket(int ticketNumber)
	{
		Thread thread = new CancelTicketThread(flightSchedule, ticketNumber);
		thread.start();
	} 
	public void updateTicket(int ticketNumber, Passenger passenger)
	{
		this.flightSchedule.updateTicket(ticketNumber,passenger);
	}
	public BoardingPass boardPassenger(Ticket ticket, Passenger passenger, Seat seat,Flight flight)
	{
		return flightSchedule.boardPassenger(ticket, passenger, seat, flight);
	}
	public BoardingPass verifyBoarding(int boardingNumber)
	{
		return this.flightSchedule.verifyBoarding(boardingNumber);
	}
	
}
