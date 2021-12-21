package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.Complaint;
import businesslogic.ComplaintList;
import businesslogic.Passenger;
import utilities.DateAndTime;

public class TestComplaints {
	@Test
	public void Test1() {
		ComplaintList CL=new ComplaintList();
		DateAndTime d=new DateAndTime(2000, 07, 07, 8, 0, 0);
		Passenger P=new Passenger("Huzaifa",d,"Male","E9","567849");
		//Complaint C=new Complaint(1,"Refreshment was not good",P);
		CL.addComplaint(1, "Refreshment was not good", P);
		Complaint Cv=new Complaint(1,"Refreshment was not good",P);
		assertEquals(Cv,CL.getComplaint(1)); 
	}
	
}
