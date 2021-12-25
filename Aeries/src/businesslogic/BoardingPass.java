package businesslogic;
import javax.persistence.*;

@Entity
@Table(name="BoardingPass")
public class BoardingPass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int number;
	@OneToOne(cascade = CascadeType.ALL)
	private Ticket associatedTicket;
	@OneToOne(cascade = CascadeType.ALL)
	private Passenger assignedPassenger;
	@OneToOne(cascade = CascadeType.ALL)
	private Seat associatedSeat;
	public BoardingPass(int number, Ticket associatedTicket, Passenger assignedPassenger,Seat associatedSeat)
	{
		this.number = number;
		this.associatedTicket = associatedTicket;
		this.assignedPassenger = assignedPassenger;
		this.associatedSeat = associatedSeat;
		PersistenceFactory.getHandler().save(this);
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
