package businesslogic;

public class Complaint {
	
	private int complaintID;
	private String description;
	public Passenger passenger;
	public Complaint(int complaintID, String description,Passenger passenger)
	{
		this.complaintID = complaintID;
		this.description = description;
		this.passenger = passenger;
	}
	public int getComplaintID()
	{
		return this.complaintID;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getDescription()
	{
		return this.description;
	}
	public Passenger getPassenger()
	{
		return this.passenger;
	}
}
