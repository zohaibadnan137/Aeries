package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.Airline;
import businesslogic.Airport;
import businesslogic.Flight;
import businesslogic.FlightPlanCatalog;
import businesslogic.FlightSchedule;
import utilities.DateAndTime;

public class TestSearchFlight {
	@Test
	public void Test1() {
		FlightSchedule FS=new FlightSchedule();
		FlightPlanCatalog FPC=new FlightPlanCatalog();
		Airport Sc=new Airport("Lahore Internatioal", "LHR", "Pakistan", "Lahore");
		Airport Des=new Airport("Multan International", "MUX", "Pakistan", "Multan");
		DateAndTime d1=new DateAndTime(2021, 12, 25, 8, 0, 0);
		DateAndTime d2=new DateAndTime(2021, 12, 25, 9, 0, 0);
		FPC.addFlightPlan("CY458", d1, d2, Sc, Des);
		FS.addFlight(FPC.getFlightPlan("CY458"), 15000,null);
		Airline A=new Airline("Aeries", null, null, FPC, FS, null);
//		A.addNewFlight(FPC.getFlightPlan("CY458"), 15000);
		assertEquals("On Time",A.searchFlight(Sc, Des).get(0).getStatus());
	}
	@Test
	public void Test2() {
		FlightPlanCatalog FPC=new FlightPlanCatalog();
		FlightSchedule FS=new FlightSchedule();
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
		FPC.addFlightPlan("CY460", d3, d4, Sc1, Des4);
		FPC.addFlightPlan("CY459", d1, d2, Sc2, Des3);
		FPC.addFlightPlan("CY461", d4, d5, Sc2, Des3);
		FPC.addFlightPlan("CY457", d3, d4, Sc3, Des2);
		FPC.addFlightPlan("CY456", d3, d5, Sc4, Des1);
		FS.addFlight(FPC.getFlightPlan("CY458"), 15000,null);
		Airline A=new Airline("Aeries", null, null, FPC, FS, null);
		A.addNewFlight(FPC.getFlightPlan("CY459"), 18000,null);
		A.addNewFlight(FPC.getFlightPlan("CY457"), 20000,null);
		A.addNewFlight(FPC.getFlightPlan("CY456"), 10000,null);
		A.addNewFlight(FPC.getFlightPlan("CY460"), 10000,null);
		A.addNewFlight(FPC.getFlightPlan("CY461"), 10000,null);
		Flight tobetested = null;
		for(int i=0;i<A.searchFlight(Sc1, Des4).size();i++)
		{
			if(A.searchFlight(Sc1, Des4).get(i).getPrice()==10000)
			{
				tobetested=A.searchFlight(Sc1, Des4).get(i);
			}
		}
		assertEquals("2021 12 26 9 0 0",tobetested.getPlan().getPlannedArrivalTime().toString());
		assertEquals("On Time",tobetested.getStatus());
//		assertEquals("2021 12 26 7 0 0",A.getFlightSchedule().getFlight("CY457").getPlan().getPlannedDepartureTime().toString());
//		assertEquals("Karachi",A.getFlightSchedule().getFlight("CY456").getPlan().getOrigin().getCity());
	}
}
