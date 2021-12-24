package userinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuEventHandler {
	
	@FXML
	private void exit(ActionEvent event)
	{
	    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	}
	
	@FXML
	private void fdoLogin(ActionEvent event)
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("FDOLogin.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Front Desk Operations");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void adminLogin(ActionEvent event)
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Admin Operations");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML 
	private void fileComplaint(ActionEvent event)
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("FileComplaint.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setTitle("File a Complaint");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
