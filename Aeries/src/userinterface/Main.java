package userinterface;
	
import businesslogic.AircraftDescription;
import businesslogic.Airline;
import businesslogic.AirlineFactory;
import businesslogic.ComplaintList;
import businesslogic.EmployeeList;
import businesslogic.Fleet;
import businesslogic.FlightPlanCatalog;
import businesslogic.FlightSchedule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
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
			
			// 
			
			
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
