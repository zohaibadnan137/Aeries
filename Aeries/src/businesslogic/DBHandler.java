package businesslogic;


import org.hibernate.Transaction;
import org.hibernate.Session;
import utilities.*;
public class DBHandler implements PersistenceHandler {
	private Transaction transaction;
	private Session session;
	public DBHandler()
	{
		try {
			this.session = HibernateUtil.getSessionFactory().openSession();
			this.transaction = session.beginTransaction();
		}catch(Exception e) {
			if (this.transaction != null) {
				this.transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean save(Object object)
	{
		try {
			session.save(object);
			transaction.commit();
			return true;
		}catch(Exception e)
		{
			if (this.transaction != null) {
				this.transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}
}
