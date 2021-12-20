package businesslogic;

import java.util.ArrayList;

import utilities.DateAndTime;

public class EmployeeList {
	private ArrayList<Employee> employees;
	
	public EmployeeList()
	{
		employees = null;
	}
	public void addEmployee(int id, String name, DateAndTime dateOfBirth, String gender, String email, String password)
	{
		if(employees==null)
		{
			employees = new ArrayList<Employee>();
		}
		employees.add(new Employee(id, name, dateOfBirth, gender, email, password));
	}
}
