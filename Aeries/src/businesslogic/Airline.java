package businesslogic;


public class Airline {
	private String name;
	private EmployeeList employeeList;
	private ComplaintList complaintList;
	public Airline(String name) {
		this.name = name;
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
}
