package businesslogic;

public class AirlineFactory {
	private static Airline airline=null;
	
	public static Airline getAirline(String name,EmployeeList employeeList,ComplaintList complaintList,FlightPlanCatalog flightPlanCatalog, FlightSchedule flightSchedule,Fleet fleet) {
		if(airline==null)
		{
			airline=new Airline(name, employeeList, complaintList, flightPlanCatalog, flightSchedule, fleet);
		}
		return airline;
	}
	public static Airline getAirline()
	{
		if(airline==null)
		{
			airline=new Airline(null, null, null, null, null, null);
		}
		return airline;
	}
}
