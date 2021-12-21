package businesslogic;

import java.util.ArrayList;
import java.util.Date;
//This is Aircraft Class
public class Aircraft {
	private AircraftDescription aircraftDescription;
	private String registrationNumber;
	private String status;
	private ArrayList<Seat> seats;
	private EmployeeList employeeList;
	private ComplaintList complaintList;
	public Aircraft(AircraftDescription aircraftDescription, String registrationNumber, String status)
	{
		seats = null;
		this.aircraftDescription = aircraftDescription;
		this.registrationNumber = registrationNumber;
		this.status = status;
	}
	public void addSeat(Seat seat)
	{
		if(seats==null)
		{
			this.seats = new ArrayList<Seat>();
		}
		seats.add(seat);
	}
	public Employee authenticateUser(String email,String password)
	{
		return employeeList.authenticateUser(email, password);
	}
	public void fileComplaint(int complaintID, String description, Passenger passenger)
	{
		complaintList.addComplaint(complaintID, description, passenger);
	}
}
