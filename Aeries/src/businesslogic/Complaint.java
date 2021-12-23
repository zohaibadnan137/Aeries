package businesslogic;

public class Complaint {
	
	private int complaintID;
	private String description;
	public BoardingPass boardingPass;
	public Complaint(int complaintID, String description,BoardingPass boardingPass)
	{
		this.complaintID = complaintID;
		this.description = description;
		this.boardingPass = boardingPass;
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
	public BoardingPass getBoardingPass()
	{
		return this.boardingPass;
	}
}
