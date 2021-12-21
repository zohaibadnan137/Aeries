module Aeries {
	requires javafx.controls;
	requires junit;
	requires java.persistence;
	requires org.hibernate.orm.core;
	
	opens userinterface to javafx.graphics, javafx.fxml;
}
