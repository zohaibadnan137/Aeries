package businesslogic;

import javax.persistence.*;


import utilities.DateAndTime;

@Entity
@Table(name="Passenger")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name="name")
	private String name;
	private DateAndTime dateOfBirth;
	@Column(name="gender")
	private String gender;
	@Column(name="address")
	private String address;
	@Column(name="passportNumber")
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
