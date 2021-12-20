package businesslogic;

import utilities.*;

public class Employee {
	private int id;
	private String name;
	private DateAndTime dateOfBirth;
	private String gender;
	private String email; 
	private String password;
	
	public Employee(int id, String name, DateAndTime dateOfBirth, String gender, String email, String password)
	{
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
	}
}
