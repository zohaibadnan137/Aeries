package businesslogic;

import java.util.ArrayList;

import utilities.DateAndTime;

public class EmployeeList {
	private ArrayList<Employee> employees;
	
	public EmployeeList()
	{
		employees = null;
	}
	public void addEmployee(int id, String name, DateAndTime dateOfBirth, String gender, String email, String password,String position)
	{
		if(employees==null)
		{
			employees = new ArrayList<Employee>();
		}
		employees.add(new Employee(id, name, dateOfBirth, gender, email, password,position));
	}
	//This method returns 0 if authentication fails, 1 for FDO and 2 for admin
	public Employee authenticateUser(String email,String password)
	{
		for(Employee employee: employees)
		{
			if(employee.authenticateUser(email, password))
			{
				return employee;
			}
		}
		return null;
	}
}
