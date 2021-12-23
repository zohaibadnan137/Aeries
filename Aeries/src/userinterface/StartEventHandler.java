package userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartEventHandler {
	
	@FXML
	private void start(ActionEvent event)
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Main Menu");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
