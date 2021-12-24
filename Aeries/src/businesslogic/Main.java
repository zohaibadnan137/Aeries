package businesslogic;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import utilities.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		FlightPlanCatalog flightPlanCatalog =new FlightPlanCatalog();
		Airport Sc = new Airport("Lahore Internatioal", "LHR", "Pakistan", "Lahore");
		Airport Des = new Airport("Multan International", "MUX", "Pakistan", "Multan");
		DateAndTime d1 = new DateAndTime(2021, 12, 25, 8, 0, 0);
		DateAndTime d2 = new DateAndTime(2021, 12, 25, 9, 0, 0);
		flightPlanCatalog.addFlightPlan("CY458", d1, d2, Sc, Des);
		FlightPlan plan = new FlightPlan("CY458", d1, d2, Sc, Des);
		
		// Create employee list
		EmployeeList list = new EmployeeList();
		DateAndTime dob = new DateAndTime(2000, 7, 13, 0, 0, 0);
		list.addEmployee(0, "Zohaib Adnan", dob, "Male", "zohaibadnan@gmail.com", "aeries", "FDO");
		list.addEmployee(1, "Muhammad Huzaifa", dob, "Male", "mhuzaifa@gmail.com", "aeries1", "Admin");
		
		// Create flight schedule
		AircraftDescription ad = new AircraftDescription("Boeing", "747", 0);
		Aircraft aircraft = new Aircraft(ad, "PK709", "Available");
		FlightSchedule flightSchedule = new FlightSchedule();
		flightSchedule.addFlight(flightPlanCatalog.getFlightPlan("CY458"), 10000, aircraft);
		
		AirlineFactory.getAirline("Aeries", list, null, flightPlanCatalog, flightSchedule, null);
		Transaction transaction = null;
		DateAndTime d3=new DateAndTime(1999, 10, 07, 8, 0, 0);
		Passenger P1=new Passenger("Asim",d2,"Male","E9","567849");
	
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(d1);
			session.save(d2);
		
			session.save(Sc);
			session.save(Des);
			session.save(plan);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		

	}

}
