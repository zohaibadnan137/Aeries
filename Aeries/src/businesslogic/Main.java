package businesslogic;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import utilities.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		
		DateAndTime d2=new DateAndTime(1999, 10, 07, 8, 0, 0);
		Passenger P1=new Passenger("Huzaifa",d2,"Male","E9","567849");
//		DBHandler handler= PersistenceFactory.getHandler();
   
	}

}
