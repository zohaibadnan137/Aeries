package businesslogic;

import java.util.ArrayList;

import utilities.DateAndTime;


public class Flight {
	private FlightPlan plan;
	private DateAndTime departure; 
	private DateAndTime arrival;
	private String status;
	private ArrayList<Ticket> tickets;
	private ArrayList<BoardingPass> boardings;

	
	public Flight(FlightPlan plan)
	{
		this.plan = plan;
		this.status = "On Time";
		this.departure = plan.getPlannedDepartureTime();
		this.arrival = plan.getPlannedArrivalTime();
		this.tickets = new ArrayList<Ticket>();
		this.boardings = null;
	}
	public void setDepartureTime(int year, int month, int day, int hour, int minute, int seconds)
	{
		departure = new DateAndTime(year, month, day, hour, minute, seconds);
	}
	public void setArrivalTime(int year, int month, int day, int hour, int minute, int seconds)
	{
		arrival = new DateAndTime(year, month, day, hour, minute, seconds);
	}
	public String getStatus()
	{
		return this.status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public void addTicket(Ticket ticket)
	{
		if(this.tickets == null)
		{
			this.tickets = new ArrayList<Ticket>();
		}
		tickets.add(ticket);
	}
	public void addBoardingPass(BoardingPass pass)
	{
		if(this.boardings == null)
		{
			this.boardings = new ArrayList<BoardingPass>();
		}
		boardings.add(pass);
	}
	public FlightPlan getPlan() {
		return plan;
	}
	public void setPlan(FlightPlan plan) {
		this.plan = plan;
	}
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	public ArrayList<BoardingPass> getBoardings() {
		return boardings;
	}
	public void setBoardings(ArrayList<BoardingPass> boardings) {
		this.boardings = boardings;
	}
	public flight
	
}
