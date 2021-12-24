package testcases;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import businesslogic.Airline;
import businesslogic.Airport;
import businesslogic.FlightPlanCatalog;
import businesslogic.FlightSchedule;
import businesslogic.Passenger;
import utilities.DateAndTime;

public class TestBookFlight {
	@Test
	public void Test1() throws FileNotFoundException, IOException
	{
		DateAndTime d=new DateAndTime(2000, 07, 07, 8, 0, 0);
		Passenger p=new Passenger("Huzaifa",d,"Male","E9","567849");
		ArrayList<Passenger> P=new ArrayList<Passenger>();
		P.add(p);
		FlightSchedule FS=new FlightSchedule();
		FlightPlanCatalog FPC=new FlightPlanCatalog();
		Airport Sc=new Airport("Lahore Internatioal", "LHR", "Pakistan", "Lahore");
		Airport Des=new Airport("Multan International", "MUX", "Pakistan", "Multan");
		DateAndTime d1=new DateAndTime(2021, 12, 25, 8, 0, 0);
		DateAndTime d2=new DateAndTime(2021, 12, 25, 9, 0, 0);
		FPC.addFlightPlan("CY458", d1, d2, Sc, Des);
		FS.addFlight(FPC.getFlightPlan("CY458"), 15000,null);
		Airline A=new Airline("Aeries", null, null, FPC, FS, null);
		A.bookTicket(A.getFlightSchedule().getFlight("CY458"), P, 10000);
		assertEquals("Huzaifa",A.getFlightSchedule().getFlight("CY458").getTickets().get(0).getPassengers().get(0).getName());
	}
	@Test
	public void Test2() throws FileNotFoundException, IOException
	{
		DateAndTime d1=new DateAndTime(2000, 8, 07, 8, 0, 0);
		DateAndTime d3=new DateAndTime(2002, 7, 4, 8, 0, 0);
		DateAndTime d2=new DateAndTime(1999, 10, 07, 8, 0, 0);
		Passenger P1=new Passenger("Huzaifa",d1,"Male","E9","567849");
		Passenger P2=new Passenger("Asim",d2,"Male","F11","876563");
		Passenger P3=new Passenger("Zohaib",d3,"Male","g13","679263");
		ArrayList<Passenger> P=new ArrayList<Passenger>();
		P.add(P1);
		P.add(P2);
		ArrayList<Passenger> PP=new ArrayList<Passenger>();
		PP.add(P3);
		FlightSchedule FS=new FlightSchedule();
		FlightPlanCatalog FPC=new FlightPlanCatalog();
		Airport Sc=new Airport("Lahore Internatioal", "LHR", "Pakistan", "Lahore");
		Airport Des=new Airport("Multan International", "MUX", "Pakistan", "Multan");
		DateAndTime D1=new DateAndTime(2021, 12, 25, 8, 0, 0);
		DateAndTime D2=new DateAndTime(2021, 12, 25, 9, 0, 0);
		FPC.addFlightPlan("CY458", D1, D2, Sc, Des);
		FS.addFlight(FPC.getFlightPlan("CY458"), 15000,null);
		Airline A=new Airline("Aeries", null, null, FPC, FS, null);
		A.bookTicket(A.getFlightSchedule().getFlight("CY458"), P, 10000);
		A.bookTicket(A.getFlightSchedule().getFlight("CY458"), PP, 20000);
		Passenger tobetested = null;
		for(int i=0;i<A.getFlightSchedule().getFlight("CY458").getTickets().size();i++)
		{
			for(int j=0;j<A.getFlightSchedule().getFlight("CY458").getTickets().get(i).getPassengers().size();j++)
			{
				if(A.getFlightSchedule().getFlight("CY458").getTickets().get(i).getPassengers().get(j).getName().equals("Huzaifa"))
				{
					tobetested=A.getFlightSchedule().getFlight("CY458").getTickets().get(i).getPassengers().get(j);
				}
			}
		}
		assertEquals("E9",tobetested.getAddress());
	}
}
