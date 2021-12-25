package businesslogic;

import java.util.ArrayList;

import javax.persistence.*;

import utilities.DateAndTime;


@Entity
@Table(name="Flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@OneToOne(cascade = CascadeType.ALL)
	private FlightPlan plan;
	@OneToOne(cascade = CascadeType.ALL)
	private DateAndTime departure;
	@OneToOne(cascade = CascadeType.ALL)
	private DateAndTime arrival;
	@Column(name="status")
	private String status;
	private ArrayList<Ticket> tickets;
	private ArrayList<BoardingPass> boardings;
	@Column(name="price")
	int price;
	@OneToOne(cascade = CascadeType.ALL)
	Aircraft aircraft;
	public Flight(FlightPlan plan,int price,Aircraft aircraft)
	{
		this.plan = plan;
		this.status = "On Time";
		this.departure = plan.getPlannedDepartureTime();
		this.arrival = plan.getPlannedArrivalTime();
		this.tickets = new ArrayList<Ticket>();
		this.boardings = null;
		this.price = price;
		this.aircraft = aircraft;
		PersistenceFactory.getHandler().save(this);
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
	public BoardingPass verifyBoarding(int boardingNumber)
	{
		for(BoardingPass b: this.boardings)
		{
			if(b.getNumber() == boardingNumber)
			{
				return b;
			}
		}
		return null;
	}
	
}
