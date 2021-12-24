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
	int price;
	
	public Flight(FlightPlan plan,int price)
	{
		this.plan = plan;
		this.status = "On Time";
		this.departure = plan.getPlannedDepartureTime();
		this.arrival = plan.getPlannedArrivalTime();
		this.tickets = new ArrayList<Ticket>();
		this.boardings = null;
		this.price = price;
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
	public void setPrice(int price)
	{
		this.price = price;
	}
	public int getPrice()
	{
		return this.price;
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
	public boolean verifyBoarding(int boardingNumber)
	{
		for(BoardingPass b: this.boardings)
		{
			if(b.getNumber() == boardingNumber)
			{
				return true;
			}
		}
		return false;
	}
	
}
