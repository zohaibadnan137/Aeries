package Threads;
import businesslogic.*;
public class CancelTicketThread extends Thread {
  FlightSchedule flightSchedule;
  int ticketNumber;
  public CancelTicketThread(FlightSchedule flightSchedule,int ticketNumber) {
	this.flightSchedule =flightSchedule;
	this.ticketNumber = ticketNumber;
 } 
  public void run()
  {
	  this.flightSchedule.cancelTicket(ticketNumber);
  }
}
