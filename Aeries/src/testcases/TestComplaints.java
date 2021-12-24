package testcases;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import businesslogic.Airline;
import businesslogic.BoardingPass;
import businesslogic.Complaint;
import businesslogic.ComplaintList;
import businesslogic.Passenger;
import utilities.DateAndTime;

public class TestComplaints {

	@Test
	public void Test1() throws FileNotFoundException, IOException {
		ComplaintList CL=new ComplaintList();
		Airline A=new Airline("Aeries", null, CL, null, null, null);
		DateAndTime d=new DateAndTime(2000, 07, 07, 8, 0, 0);
		Passenger P=new Passenger("Huzaifa",d,"Male","E9","567849");
		BoardingPass pass=new BoardingPass(12, null, P, null);
		A.fileComplaint("Refreshment was not fine", pass);
		CL=A.getComplaintList();
		ArrayList<Complaint> CLL=CL.getComplaints();
		assertEquals("Huzaifa",CLL.get(0).getBoardingPass().getAssignedPassenger().getName()); 
	}
	@Test
	public void Test2() throws FileNotFoundException, IOException {
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
		A.fileComplaint("Refreshment was not good", pass1);
		A.fileComplaint("Temperature was not as it should be.", pass1);
		A.fileComplaint("Washroom was not cleaned.", pass1);
		A.fileComplaint("Food Quality was kinda low", pass2);
		A.fileComplaint("Air hostess was not cooperative", pass2);
		A.fileComplaint("Luggage got damaged during loading", pass3);
		A.fileComplaint("there was error in tabs", pass3);
		CL=A.getComplaintList();
		BoardingPass pp=null;
		ArrayList<Complaint> CLL=CL.getComplaints();
		for(int i=0;i<CLL.size();i++)
		{
			if(CLL.get(i).getDescription().equals("Refreshment was not good"))
			{
				pp=CLL.get(i).getBoardingPass();
			}
		}
		assertEquals("Huzaifa",pp.getAssignedPassenger().getName()); 
	}
	
}
