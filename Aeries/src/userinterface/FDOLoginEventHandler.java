package userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FDOLoginEventHandler {
	
	private String username;
	private String password;
	
    @FXML
    private PasswordField passwordInput;
    @FXML
    private TextField usernameInput;
    
    @FXML
    private Label invalidCredentials;
    
    @FXML
    private void start(MouseEvent event)
    {
		invalidCredentials.setText("");
    }
	
	@FXML
	private void authenticate(ActionEvent event)
	{
		boolean success = false;
		//success = Airline.authenticate(usernameInput.getText(), passwordInput.getText());
		if(success)
		{
			// Call main menu
		}
		else
		{
			usernameInput.setText("");
			passwordInput.setText("");
			invalidCredentials.setText("Invalid credentials. Please try again.");
		}
	}

}