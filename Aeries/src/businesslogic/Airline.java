package businesslogic;


public class Airline {
	private String name;
	private EmployeeList employeeList;
	private ComplaintList complaintList;
	private FlightPlanCatalog flightPlanCatalog;
	private FlightSchedule flightSchedule;
	private Fleet fleet;
	public Airline() {
		this.name = "";
		this.employeeList = null;
		this.complaintList = null;
		this.flightPlanCatalog = null;
		this.flightSchedule = null;
		this.fleet = null;
	}
	public Airline(String name,EmployeeList employeeList,ComplaintList complaintList,FlightPlanCatalog flightPlanCatalog, FlightSchedule flightSchedule,Fleet fleet) {
		this.name = name;
		this.employeeList = employeeList;
		this.complaintList = complaintList;
		this.flightPlanCatalog = flightPlanCatalog;
		this.flightSchedule = flightSchedule;
		this.fleet = fleet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EmployeeList getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(EmployeeList employeeList) {
		this.employeeList = employeeList;
	}
	public FlightPlanCatalog getFlightPlanCatalog() {
		return flightPlanCatalog;
	}
	public void setFlightPlanCatalog(FlightPlanCatalog flightPlanCatalog) {
		this.flightPlanCatalog = flightPlanCatalog;
	}
	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}
	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}
	public Fleet getFleet() {
		return fleet;
	}
	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}
	public void setComplaintList(ComplaintList complaintList) {
		this.complaintList = complaintList;
	}
	
	public Employee authenticateUser(String email,String password)
	{
		return employeeList.authenticateUser(email, password);
	}
	public void fileComplaint(int complaintID, String description, Passenger passenger)
	{
		complaintList.addComplaint(complaintID, description, passenger);
	}
	public ComplaintList getComplaintList()
	{
		return this.complaintList;
	}
	public void addFlight()
}
