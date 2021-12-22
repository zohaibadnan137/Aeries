package businesslogic;

import java.util.ArrayList;

import utilities.DateAndTime;

public class Ticket {
	private int number;
	private int amountPaid;
	private DateAndTime date;
	ArrayList<Passenger> passengers;
	
	public Ticket(int number, int amountPaid, DateAndTime date) {
		this.number = number;
		this.amountPaid = amountPaid;
		this.date = date;
		passengers = new ArrayList<Passenger>();
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public int getAmountPaid() {
		return amountPaid;
	}
	
	public void addPassenger(Passenger p)
	{
		this.passengers.add(p);
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public DateAndTime getDate() {
		return date;
	}

	public void setDate(DateAndTime date) {
		this.date = date;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}
	public String printTicket()
	{
		return this.toString();
	}
	public String toString()
	{
		String retString = "Ticket Number: "+this.number+"\n"
				+"Amount Paid: "+this.amountPaid+"\n"
				+"Booking Date: "+this.date+"\n"
				+"Passengers: \n";
		for(Passenger p: passengers)
		{
			retString+="• "+p.getName()+"\n";
		}
		return retString;
	}
}
