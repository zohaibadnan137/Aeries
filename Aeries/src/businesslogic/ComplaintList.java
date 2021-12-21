package businesslogic;

import java.util.ArrayList;

public class ComplaintList {
	private ArrayList<Complaint> complaints;
	
	public ComplaintList() {
		complaints = null;
	}
	public void addComplaint(Complaint complaint)
	{
		this.complaints.add(complaint);
	}
	public void addComplaint(int complaintID, String description,Passenger passenger)
	{
		this.complaints.add(new Complaint(complaintID, description, passenger));
	}
	public Complaint getComplaint(int ID)
	{
		for(Complaint complaint : complaints)
		{
			if(complaint.getComplaintID() == ID)
			{
				return complaint;
			}
		}
		return null;
	}
}
