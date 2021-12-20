package businesslogic;

public class Complaint {
	
	private int complaintID;
	private String description;
	
	public Complaint(int complaintID, String description)
	{
		this.complaintID = complaintID;
		this.description = description;
	
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
}
