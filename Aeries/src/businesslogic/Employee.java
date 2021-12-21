package businesslogic;

import utilities.*;

public class Employee {
	private int id;
	private String name;
	private DateAndTime dateOfBirth;
	private String gender;
	private String email; 
	private String password;
	private String position;
	
	public Employee(int id, String name, DateAndTime dateOfBirth, String gender, String email, String password,String position)
	{
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.position=position;
	}
	public boolean authenticateUser(String email, String password)
	{
		if(this.email==email && this.password==password)
		{
			return true;
		}
		return false;
	}
	public String getName()
	{
		return this.name;
	}
	public String getPosistion()
	{
		return this.position;
	}
	public void setPosition(String position)
	{
		this.position = position;
	}
	//Dummy comment
}
