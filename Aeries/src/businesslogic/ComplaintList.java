package businesslogic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import utilities.*;
public class ComplaintList {
	private ArrayList<Complaint> complaints;

	public ComplaintList() {
		complaints = null;
	}

	public void addComplaint(String description,BoardingPass boardingPass) throws FileNotFoundException, IOException
	{
		if(this.complaints == null)
		{
			this.complaints = new ArrayList<Complaint>();
		}
		this.complaints.add(new Complaint(IdDispenser.getID(), description, boardingPass));
	}
	public ArrayList<Complaint> getComplaints()
	{
		return this.complaints;
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
