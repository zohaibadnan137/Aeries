package utilities;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import businesslogic.*;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/aeries?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "admin");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "false");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Passenger.class);
				configuration.addAnnotatedClass(Airline.class);
				configuration.addAnnotatedClass(Aircraft.class);
				configuration.addAnnotatedClass(Flight.class);
				configuration.addAnnotatedClass(DateAndTime.class);
				configuration.addAnnotatedClass(AircraftDescription.class);
				configuration.addAnnotatedClass(Seat.class);
				configuration.addAnnotatedClass(FlightPlan.class);
				configuration.addAnnotatedClass(Flight.class);
				configuration.addAnnotatedClass(Employee.class);
				configuration.addAnnotatedClass(Complaint.class);
				configuration.addAnnotatedClass(BoardingPass.class);
				configuration.addAnnotatedClass(Airport.class);
				configuration.addAnnotatedClass(Ticket.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
