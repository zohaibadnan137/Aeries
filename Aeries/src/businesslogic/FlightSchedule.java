package businesslogic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import utilities.DateAndTime;
import utilities.IdDispenser;

import javax.persistence.*;


public class FlightSchedule {
	private ArrayList<Flight> flights;
	
	public FlightSchedule()
	{
		flights = null;
	}
	public Flight addFlight(FlightPlan plan,int price,Aircraft aircraft) throws FileNotFoundException, IOException
	{
		if(flights == null)
		{
			flights = new ArrayList<Flight>();
		}
		Flight newFlight = new Flight(plan,price,aircraft);
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
	public void cancelTicket(int ticketNumber)
	{
		for(Flight flight: flights)
		{
			ArrayList<Ticket> tickets = flight.getTickets();
			for(Ticket ticket : tickets)
			{
				if(ticket.getNumber()==ticketNumber)
				{
					ticket.cancelTicket();
				}
			}
		}
	}
	public void updateTicket(int ticketNumber, Passenger passenger)
	{
		for(Flight flight: flights)
		{
			ArrayList<Ticket> tickets = flight.getTickets();
			for(Ticket ticket : tickets)
			{
				if(ticket.getNumber()==ticketNumber)
				{
					ticket.addPassenger(passenger); 
				}
			}
		}
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
	public BoardingPass verifyBoarding(int boardingNumber)
	{
		for(Flight f: this.flights)
		{
			if(f.verifyBoarding(boardingNumber)!=null)
			{
				return f.verifyBoarding(boardingNumber);
			}
		}
		return null;
	}
	public Ticket bookTicket(Flight flight,ArrayList<Passenger> passengers,int amountPaid) throws FileNotFoundException, IOException
	{
		Flight flightToBook = this.getFlight(flight.getPlan().getFlightNumber());
		if(flightToBook==null)
		{
			return null;
		}
		Date d = new Date();
		DateAndTime currentDate = new DateAndTime(d.getYear(),d.getMonth(),d.getDay(),d.getHours(),d.getMinutes(),d.getSeconds());
		Ticket newTicket = new Ticket(IdDispenser.getID(),amountPaid,currentDate,passengers);
		flightToBook.addTicket(newTicket);
		return newTicket;
		
	}
	public BoardingPass boardPassenger(Ticket ticket, Passenger passenger, Seat seat,Flight flight)
	{
		Flight toBoardOn = this.getFlight(flight.getPlan().getFlightNumber());
		if(toBoardOn==null)
		{
			return null;
		}
		BoardingPass newBoarding= new BoardingPass((int) (Math.random() * (1000 - 1)) + 1, ticket, passenger, seat);
		toBoardOn.addBoardingPass(newBoarding);
		return newBoarding;
	}
}
