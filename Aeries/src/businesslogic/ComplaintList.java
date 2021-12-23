package businesslogic;

import java.util.ArrayList;


public class ComplaintList {
	private ArrayList<Complaint> complaints;
	
	public ComplaintList() {
		complaints = null;
	}

	public void addComplaint(int complaintID, String description,BoardingPass boardingPass)
	{
		if(this.complaints == null)
		{
			this.complaints = new ArrayList<Complaint>();
		}
		this.complaints.add(new Complaint(complaintID, description, boardingPass));
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
