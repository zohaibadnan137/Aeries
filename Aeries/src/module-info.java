module Aeries {
	requires javafx.controls;
	requires junit;
<<<<<<< HEAD
	requires java.persistence;
	requires org.hibernate.orm.core;
=======
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
>>>>>>> branch 'master' of git@github.com:zohaibadnan137/Aeries.git
	
	opens userinterface to javafx.graphics, javafx.fxml;
}
