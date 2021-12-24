package userinterface;

import businesslogic.Airline;
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
	
	Airline currentAirline = AirlineFactory.getAirline();
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
    private void authenticateBoardingPassNumber(MouseEvent event)
    {
    	String boardingPassNumber = boardingPassNumberInput.getText();
    	currentBoardingPass = currentAirline.verifyBoarding(Integer.parseInt(boardingPassNumber));
    	if(currentBoardingPass == null)
    	{
    		//invalid = true;
    		invalidBoardingPassNumber.setText("Invalid boarding pass number. Please try again.");
    	}
    }
    
    @FXML
	private void submit(ActionEvent event)
	{
    	if(invalid == false)
    	{
    		String complaint = complaintInput.getText();
    		//currentAirline.fileComplaint(0, complaint, currentBoardingPass);
    		// Load complaint successfully filed page 
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
