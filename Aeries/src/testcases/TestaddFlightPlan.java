package testcases;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.Airline;
import businesslogic.Airport;
import businesslogic.EmployeeList;
import businesslogic.FlightPlanCatalog;
import utilities.DateAndTime;

public class TestaddFlightPlan {
	@Test
	public void Test1() {
		FlightPlanCatalog FPC=new FlightPlanCatalog();
		Airport Sc=new Airport("Lahore Internatioal", "LHR", "Pakistan", "Lahore");
		Airport Des=new Airport("Multan International", "MUX", "Pakistan", "Multan");
		DateAndTime d1=new DateAndTime(2021, 12, 25, 8, 0, 0);
		DateAndTime d2=new DateAndTime(2021, 12, 25, 9, 0, 0);
		FPC.addFlightPlan("CY458", d1, d2, Sc, Des);
		Airline A=new Airline("Aeries", null, null, FPC, null, null);
		assertEquals("Lahore",A.getFlightPlan("CY458").getOrigin().getCity());
	}
	@Test
	public void Test2() {
		FlightPlanCatalog FPC=new FlightPlanCatalog();
		Airport Sc1=new Airport("Lahore Internatioal", "LHR", "Pakistan", "Lahore");
		Airport Sc2=new Airport("Sialkot Internatioal", "SKT", "Pakistan", "Sialkot");
		Airport Sc3=new Airport("Multan Internatioal", "MUX", "Pakistan", "Multan");
		Airport Sc4=new Airport("Karachi Internatioal", "KHI", "Pakistan", "Karachi");
		Airport Des1=new Airport("Lahore Internatioal", "LHR", "Pakistan", "Lahore");
		Airport Des2=new Airport("Sialkot Internatioal", "SKT", "Pakistan", "Sialkot");
		Airport Des3=new Airport("Multan Internatioal", "MUX", "Pakistan", "Multan");
		Airport Des4=new Airport("Karachi Internatioal", "KHI", "Pakistan", "Karachi");
		DateAndTime d1=new DateAndTime(2021, 12, 25, 8, 0, 0);
		DateAndTime d2=new DateAndTime(2021, 12, 25, 9, 0, 0);
		DateAndTime d3=new DateAndTime(2021, 12, 26, 7, 0, 0);
		DateAndTime d4=new DateAndTime(2021, 12, 26, 9, 0, 0);
		DateAndTime d5=new DateAndTime(2021, 12, 26, 8, 0, 0);
		FPC.addFlightPlan("CY458", d1, d2, Sc1, Des4);
		FPC.addFlightPlan("CY459", d1, d2, Sc2, Des3);
		FPC.addFlightPlan("CY457", d3, d4, Sc3, Des2);
		FPC.addFlightPlan("CY456", d3, d5, Sc4, Des1);
		Airline A=new Airline("Aeries", null, null, FPC, null, null);
		assertEquals("Karachi",A.getFlightPlan("CY458").getDestination().getCity());
		assertEquals("Sialkot Internatioal",A.getFlightPlan("CY459").getOrigin().getName());
		assertEquals("2021 12 26 7 0 0",A.getFlightPlan("CY457").getPlannedDepartureTime().toString());
		assertEquals("Karachi",A.getFlightPlan("CY456").getOrigin().getCity());
	}
}
