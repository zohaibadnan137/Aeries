module Aeries {
	requires javafx.controls;
	requires junit;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	opens userinterface to javafx.graphics, javafx.fxml;
}
