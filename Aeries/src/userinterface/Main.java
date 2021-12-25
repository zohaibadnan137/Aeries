package userinterface;
	
import java.util.ArrayList;

import businesslogic.Aircraft;
import businesslogic.AircraftDescription;
import businesslogic.Airline;
import businesslogic.AirlineFactory;
import businesslogic.Airport;
import businesslogic.ComplaintList;
import businesslogic.EmployeeList;
import businesslogic.Fleet;
import businesslogic.Flight;
import businesslogic.FlightPlan;
import businesslogic.FlightPlanCatalog;
import businesslogic.FlightSchedule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import utilities.DateAndTime;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Create lists
			EmployeeList employeeList = new EmployeeList();
			ComplaintList complaintList = new ComplaintList();
			FlightPlanCatalog flightPlanCatalog = new FlightPlanCatalog();
			FlightSchedule flightSchedule = new FlightSchedule();
			Fleet fleet = new Fleet();
			
			// Create airline
			Airline airline = AirlineFactory.getAirline("Aeries", employeeList, complaintList, flightPlanCatalog, flightSchedule, fleet);
			
			// Create aircrafts
			Aircraft aircraft1 = airline.addAircraft(100, "Available", new AircraftDescription("Boeing", "747"));
			Aircraft aircraft2 = airline.addAircraft(101, "Available", new AircraftDescription("Airbus", "A330"));
			Aircraft aircraft3 = airline.addAircraft(102, "Available", new AircraftDescription("Boeing", "777"));
			
			// Create airports
			Airport airport1 = new Airport("Lahore International", "LHR", "Pakistan", "Lahore");
			Airport airport2 = new Airport("Sialkot International", "SKT", "Pakistan", "Sialkot");
			Airport airport3 = new Airport("Multan International", "MUX", "Pakistan", "Multan");
			Airport airport4 = new Airport("Karachi International", "KHI", "Pakistan", "Karachi");
			
			// Create flight dates
			DateAndTime departureTime1 = new DateAndTime(2021, 12, 25, 7, 0, 0);
			DateAndTime departureTime2 = new DateAndTime(2021, 12, 26, 8, 0, 0);
			DateAndTime departureTime3 = new DateAndTime(2021, 12, 27, 9, 0, 0);
			DateAndTime arrivalTime1 = new DateAndTime(2021, 12, 25, 9, 0, 0);
			DateAndTime arrivalTime2 = new DateAndTime(2021, 12, 26, 10, 0, 0);
			DateAndTime arrivalTime3 = new DateAndTime(2021, 12, 27, 11, 0, 0);
			
			// Create flight plans
			FlightPlan flightPlan1 = airline.addFlightPlan("PK303", departureTime1, arrivalTime1, airport1, airport2);
			FlightPlan flightPlan2 = airline.addFlightPlan("PK301", departureTime2, arrivalTime2, airport2, airport3);
			FlightPlan flightPlan3 = airline.addFlightPlan("PK302", departureTime3, arrivalTime3, airport3, airport4);
			
			// Create flights
			Flight flight1 = airline.addNewFlight(flightPlan1, 10000, aircraft1);
			Flight flight2 = airline.addNewFlight(flightPlan2, 12000, aircraft2);
			Flight flight3 = airline.addNewFlight(flightPlan3, 11000, aircraft3);
			
			ArrayList<Flight> flights = airline.getAllScheduledFlights();
			if(flights == null)
				System.out.println("ERROR");
			
			// Create date of birth 
			DateAndTime dob = new DateAndTime(2000, 12, 10, 0, 0, 0);
			
			// Create employees
			airline.getEmployeeList().addEmployee(1, "Asim Ali", dob, "Male", "asim@gmail.com", "1234" ,"FDO");
			airline.getEmployeeList().addEmployee(2, "Muhammad Huzaifa", dob, "Male", "huzaifa@gmail.com", "1234", "Admin");
			airline.getEmployeeList().addEmployee(3, "Zohaib Adnan", dob, "Male", "zohaib@gmail.com", "1234", "FDO");
			
			Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
			primaryStage.setTitle("Aeries");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
