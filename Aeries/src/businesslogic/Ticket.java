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
		passengers = null;
	}
}
