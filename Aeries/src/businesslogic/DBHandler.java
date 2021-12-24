package businesslogic;


import org.hibernate.Transaction;
import org.hibernate.Session;
import utilities.*;
public class DBHandler implements PersistenceHandler {
	private Transaction transaction;
	private Session session;
	public DBHandler()
	{
	}
	
	@Override
	public boolean save(Object object)
	{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(object);
			// commit transaction
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}
}
