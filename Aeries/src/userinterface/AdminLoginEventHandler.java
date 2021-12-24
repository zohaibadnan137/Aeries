package userinterface;

import businesslogic.AirlineFactory;
import businesslogic.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminLoginEventHandler {
	
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
		Employee currentEmployee = null;
		currentEmployee = AirlineFactory.getAirline().authenticateUser(usernameInput.getText(), passwordInput.getText());
		
		if(currentEmployee != null)
		{
			if(currentEmployee.getPosition() == "Admin")
			{
				try 
				{
					Parent root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
					Stage primaryStage = new Stage();
					primaryStage.setTitle("Admin Operations");
					primaryStage.setScene(new Scene(root));
					primaryStage.show();
					((Node)(event.getSource())).getScene().getWindow().hide();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			else
			{
				usernameInput.setText("");
				passwordInput.setText("");
				invalidCredentials.setText("You do not have admin privileges.");
			}
		}
		else
		{
			usernameInput.setText("");
			passwordInput.setText("");
			invalidCredentials.setText("Invalid credentials. Please try again.");
		}
	}

}
