package userinterface;

import java.io.IOException;

import Exceptions.InvalidBoardingPassException;
import businesslogic.AirlineFactory;
import businesslogic.BoardingPass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FileComplaintEventHandler {
	
	BoardingPass currentBoardingPass;
	boolean invalid;
	
    @FXML
    private TextField boardingPassNumberInput;

    @FXML
    private TextArea complaintInput;

    @FXML
    private Label invalidBoardingPassNumber;
	
    @FXML
    private void start(MouseEvent event)
    {
		invalidBoardingPassNumber.setText("");
		invalid = false;
    }
    
    @FXML
    private void authenticateBoardingPassNumber(MouseEvent event) throws InvalidBoardingPassException
    {
    	currentBoardingPass = AirlineFactory.getAirline().verifyBoarding(Integer.parseInt(boardingPassNumberInput.getText()));
    	if(currentBoardingPass == null)
    	{
    		invalid = true;
    		invalidBoardingPassNumber.setText("Invalid boarding pass number. Please try again.");
    		throw new InvalidBoardingPassException("Invalid boarding pass number.");
    	}
    }
    
    @FXML
	private void submit(ActionEvent event) throws IOException
	{
    	if(invalid == false && complaintInput.getText() != "")
    	{
    		AirlineFactory.getAirline().fileComplaint(complaintInput.getText(), currentBoardingPass);
    		    	
			try 
			{
				Parent root = FXMLLoader.load(getClass().getResource("FileComplaintSucess.fxml"));
				Stage primaryStage = new Stage();
				primaryStage.setTitle("Complaint Successfully Filed");
				primaryStage.setScene(new Scene(root));
				primaryStage.show();
				((Node)(event.getSource())).getScene().getWindow().hide();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
    	}
	}

}
