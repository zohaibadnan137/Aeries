package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.Airline;
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
		CL.addComplaint(1, "Refreshment was not fine", P);
		assertEquals("Refreshment was not fine",CL.getComplaint(1).getDescription()); 
	}
	@Test
	public void Test2() {
		ComplaintList CL=new ComplaintList();
		DateAndTime d1=new DateAndTime(2000, 8, 07, 8, 0, 0);
		DateAndTime d3=new DateAndTime(2002, 7, 4, 8, 0, 0);
		DateAndTime d2=new DateAndTime(1999, 10, 07, 8, 0, 0);
		Passenger P1=new Passenger("Huzaifa",d1,"Male","E9","567849");
		Passenger P2=new Passenger("Asim",d2,"Male","F11","876563");
		Passenger P3=new Passenger("Zohaib",d3,"Male","g13","679263");
		CL.addComplaint(1, "Refreshment was not good", P1);
		CL.addComplaint(2, "Temperature was not as it should be.", P1);
		CL.addComplaint(3, "Washroom was not cleaned.", P1);
		CL.addComplaint(4, "Food Quality was kinda low", P2);
		CL.addComplaint(5, "Air hostess was not cooperative", P2);
		CL.addComplaint(6, "Luggage got damaged during loading", P3);
		CL.addComplaint(7, "there was error in tabs", P3);
		assertEquals("Refreshment was not good",CL.getComplaint(1).getDescription()); 
		assertEquals("Food Quality was kinda low",CL.getComplaint(4).getDescription());
		assertEquals("Luggage got damaged during loading",CL.getComplaint(6).getDescription());		
	}
	
}
