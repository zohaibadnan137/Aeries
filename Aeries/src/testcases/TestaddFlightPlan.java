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
		assertEquals("CY458",A.getFlightPlanCatalog().getFlightPlans().get(0).getFlightNumber());
	}
}
