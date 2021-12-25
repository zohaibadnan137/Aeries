package businesslogic;

public class PersistenceFactory {
	private static PersistenceHandler persistenceHandler=null;
	
	public static PersistenceHandler getHandler() {
		if(persistenceHandler==null)
		{
			persistenceHandler= new DBHandler();
		}
		return new DBHandler();
	}
}
