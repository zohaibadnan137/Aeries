package userinterface;
	
import businesslogic.Aircraft;
import businesslogic.AircraftDescription;
import businesslogic.AirlineFactory;
import businesslogic.Airport;
import businesslogic.EmployeeList;
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
			
			// Create flight plan
			FlightPlanCatalog flightPlanCatalog =new FlightPlanCatalog();
			Airport Sc = new Airport("Lahore Internatioal", "LHR", "Pakistan", "Lahore");
			Airport Des = new Airport("Multan International", "MUX", "Pakistan", "Multan");
			DateAndTime d1 = new DateAndTime(2021, 12, 25, 8, 0, 0);
			DateAndTime d2 = new DateAndTime(2021, 12, 25, 9, 0, 0);
			flightPlanCatalog.addFlightPlan("CY458", d1, d2, Sc, Des);
			
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
