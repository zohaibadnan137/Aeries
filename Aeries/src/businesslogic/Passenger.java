package businesslogic;

import utilities.DateAndTime;

public class Passenger {
	private String name;
	private DateAndTime dateOfBirth;
	private String gender;
	private String address;
	private String passportNumber;
	public Passenger(String name, DateAndTime dateOfBirth, String gender, String address, String passportNumber)
	{
		this.name=name;
		this.dateOfBirth=dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.passportNumber=passportNumber;
	}
}
