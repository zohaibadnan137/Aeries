package businesslogic;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import utilities.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		Transaction transaction = null;
		DateAndTime d2=new DateAndTime(1999, 10, 07, 8, 0, 0);
		Passenger P1=new Passenger("Huzaifa",d2,"Male","E9","567849");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(d2);
			session.save(P1);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		

	}

}
