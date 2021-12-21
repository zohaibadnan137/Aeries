module Aeries {
	requires javafx.controls;
	requires junit;
	
	opens userinterface to javafx.graphics, javafx.fxml;
}
