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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Ticket getAssociatedTicket() {
		return associatedTicket;
	}
	public void setAssociatedTicket(Ticket associatedTicket) {
		this.associatedTicket = associatedTicket;
	}
	public Passenger getAssignedPassenger() {
		return assignedPassenger;
	}
	public void setAssignedPassenger(Passenger assignedPassenger) {
		this.assignedPassenger = assignedPassenger;
	}
	public Seat getAssociatedSeat() {
		return associatedSeat;
	}
	public void setAssociatedSeat(Seat associatedSeat) {
		this.associatedSeat = associatedSeat;
	}
	
}
