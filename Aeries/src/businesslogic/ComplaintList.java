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
}
