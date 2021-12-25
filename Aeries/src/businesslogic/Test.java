package businesslogic;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import utilities.*;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException,FileNotFoundException,IOException {
		DateAndTime dob1=new DateAndTime(2000, 07, 07, 8, 0, 0);
		DateAndTime dob2=new DateAndTime(2001, 04, 8, 7, 0, 0);
		DateAndTime dob3=new DateAndTime(2002, 03, 07, 9, 0, 0);
		
		EmployeeList e=new EmployeeList();
		e.addEmployee(1,"Asim Ali",dob1,"Male","Asim@gmail.com","12345","FDO");
		e.addEmployee(3, "Zohaib", dob3, "Male","Zohaib@gmail.com", "12345", "FDO");
		ComplaintList CL=new ComplaintList();
		DateAndTime dd1=new DateAndTime(2000, 8, 07, 8, 0, 0);
		DateAndTime dd3=new DateAndTime(2002, 7, 4, 8, 0, 0);
		DateAndTime dd2=new DateAndTime(1999, 10, 07, 8, 0, 0);
		Passenger P1=new Passenger("adnan",dd1,"Male","E9","567849");
		Passenger P2=new Passenger("shamshad",dd2,"Male","F11","876563");
		Passenger P3=new Passenger("hassan",dd3,"Male","g13","679263");
		BoardingPass pass1=new BoardingPass(12, null, P1, null);
		BoardingPass pass2=new BoardingPass(12, null, P2, null);
		BoardingPass pass3=new BoardingPass(12, null, P3, null);
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
		FlightSchedule FS=new FlightSchedule();
		FS.addFlight(FPC.getFlightPlan("CY458"), 15000,null);
		Fleet F=new Fleet();
		AircraftDescription ACD1=new AircraftDescription("airblue", "B557");
		AircraftDescription ACD2=new AircraftDescription("PIA", "B507");
		AircraftDescription ACD3=new AircraftDescription("Qatar", "C557");
		Airline A=new Airline("Aeries", e, CL, FPC, FS, F);
		A.addNewFlight(FPC.getFlightPlan("CY459"), 18000,null);
		A.addNewFlight(FPC.getFlightPlan("CY457"), 20000,null);
		A.addNewFlight(FPC.getFlightPlan("CY456"), 10000,null);
		A.addAircraft(1, "Available", ACD1);
		A.addAircraft(2, "Available", ACD2);
		A.addAircraft(3, "Available", ACD3);
		A.fileComplaint("Refreshment was not good", pass1);
		A.fileComplaint("Temperature was not as it should be.", pass1);
		A.fileComplaint("Washroom was not cleaned.", pass1);
		A.fileComplaint("Food Quality was kinda low", pass2);
		A.fileComplaint("Air hostess was not cooperative", pass2);
		A.fileComplaint("Luggage got damaged during loading", pass3);
		A.fileComplaint("there was error in tabs", pass3);
		Complaint c =A.getComplaintList().getComplaints().get(0);
		// Create flight schedule
////		AircraftDescription ad = new AircraftDescription("Boeing", "747", 0);
////		Aircraft aircraft = new Aircraft(ad, "PK709", "Available");
////		FlightSchedule flightSchedule = new FlightSchedule();
////		flightSchedule.addFlight(flightPlanCatalog.getFlightPlan("CY458"), 10000, aircraft);
//			BoardingPass bp = new BoardingPass()
////		AirlineFactory.getAirline("Aeries", list, null, flightPlanCatalog, flightSchedule, null);
////		DateAndTime d3=new DateAndTime(1999, 10, 07, 8, 0, 0);
////		Passenger P1=new Passenger("Asim",d2,"Male","E9","567849");
//	
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			// start a transaction
//			transaction = session.beginTransaction();
//			// save the student object
//			session.save(c);
//			// commit transaction
//			transaction.commit();
//		} catch (Exception es) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			es.printStackTrace();
//		}
		

	}

}
