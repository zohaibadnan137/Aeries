package businesslogic;

public class BoardingPass {
	private int number;
	private Ticket associatedTicket;
	private Passenger assignedPassenger;
	private Seat associatedSeat;
	public BoardingPass(int number, Ticket associatedTicket, Passenger assignedPassenger,Seat associatedSeat)
	{
		this.number = number;
		this.associatedTicket = associatedTicket;
		this.assignedPassenger = assignedPassenger;
		this.associatedSeat = associatedSeat;
	}
}
