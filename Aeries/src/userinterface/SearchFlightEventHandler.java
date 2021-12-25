package userinterface;

import java.net.URL;
import java.util.ResourceBundle;

import businesslogic.AirlineFactory;
import businesslogic.Flight;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SearchFlightEventHandler implements Initializable {

	@FXML
    private TableColumn<Flight, String> aircraft;

    @FXML
    private TableColumn<Flight, String> arrival;

    @FXML
    private TableColumn<Flight, String> availableSeats;

    @FXML
    private TableColumn<Flight, String> departure;

    @FXML
    private TableColumn<Flight, String> destination;

    @FXML
    private TableColumn<Flight, String> id;

    @FXML
    private TableColumn<Flight, String> origin;

    @FXML
    private TableView<Flight> table;

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		id.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getID())));
		origin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlan().getOrigin().getCity()));
		destination.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlan().getDestination().getCity()));
		departure.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDepartureTime().getDateAndTime()));
		arrival.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArrivalTime().getDateAndTime()));
		aircraft.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAircraft().getAircraftDescription().getModel()));
		availableSeats.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAircraft().getNumberOfAvailableSeats())));

		ObservableList<Flight> flights = FXCollections.observableArrayList(AirlineFactory.getAirline().getAllScheduledFlights());
		
		table.setItems(flights);		
	}
	
	@FXML 
	private void search(ActionEvent event)
	{
		
	}
}
