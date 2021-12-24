package userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class SearchFlightEventHandler {
	
    @FXML
    private TableColumn<?, ?> aircraft;

    @FXML
    private TableColumn<?, ?> arrival;

    @FXML
    private TableColumn<?, ?> availableSeats;

    @FXML
    private TableColumn<?, ?> departure;

    @FXML
    private TableColumn<?, ?> destination;

    @FXML
    private TableColumn<?, ?> origin;
	
	@FXML 
	private void search(ActionEvent event)
	{
		
	}

}
