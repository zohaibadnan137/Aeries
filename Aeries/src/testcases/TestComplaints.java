package testcases;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import businesslogic.Airline;
import businesslogic.BoardingPass;
import businesslogic.ComplaintList;
import businesslogic.Passenger;
import utilities.DateAndTime;

public class TestComplaints {

	@Test
	public void Test1() {
		ComplaintList CL=new ComplaintList();
		Airline A=new Airline("Aeries", null, CL, null, null, null);
		DateAndTime d=new DateAndTime(2000, 07, 07, 8, 0, 0);
		Passenger P=new Passenger("Huzaifa",d,"Male","E9","567849");
		BoardingPass pass=new BoardingPass(12, null, P, null);
		A.fileComplaint(1, "Refreshment was not fine", pass);
		CL=A.getComplaintList();
		assertEquals("Huzaifa",CL.getComplaint(1).getBoardingPass().getAssignedPassenger().getName()); 
	}
	@Test
	public void Test2() {
		ComplaintList CL=new ComplaintList();
		Airline A=new Airline("Aeries", null, CL, null, null, null);
		DateAndTime d1=new DateAndTime(2000, 8, 07, 8, 0, 0);
		DateAndTime d3=new DateAndTime(2002, 7, 4, 8, 0, 0);
		DateAndTime d2=new DateAndTime(1999, 10, 07, 8, 0, 0);
		Passenger P1=new Passenger("Huzaifa",d1,"Male","E9","567849");
		Passenger P2=new Passenger("Asim",d2,"Male","F11","876563");
		Passenger P3=new Passenger("Zohaib",d3,"Male","g13","679263");
		BoardingPass pass1=new BoardingPass(12, null, P1, null);
		BoardingPass pass2=new BoardingPass(12, null, P2, null);
		BoardingPass pass3=new BoardingPass(12, null, P3, null);
		A.fileComplaint(1, "Refreshment was not good", pass1);
		A.fileComplaint(2, "Temperature was not as it should be.", pass1);
		A.fileComplaint(3, "Washroom was not cleaned.", pass1);
		A.fileComplaint(4, "Food Quality was kinda low", pass2);
		A.fileComplaint(5, "Air hostess was not cooperative", pass2);
		A.fileComplaint(6, "Luggage got damaged during loading", pass3);
		A.fileComplaint(7, "there was error in tabs", pass3);
		CL=A.getComplaintList();
		assertEquals("Refreshment was not good",CL.getComplaint(1).getDescription()); 
		assertEquals("876563",CL.getComplaint(4).getBoardingPass().getAssignedPassenger().getPassportNumber());
		assertEquals("g13",CL.getComplaint(6).getBoardingPass().getAssignedPassenger().getAddress());		
	}
	
}
