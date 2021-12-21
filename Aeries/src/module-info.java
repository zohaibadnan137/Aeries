module Aeries {
	requires javafx.controls;
	requires junit;
	requires java.persistence;
	requires org.hibernate.orm.core;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	opens userinterface to javafx.graphics, javafx.fxml;
}
