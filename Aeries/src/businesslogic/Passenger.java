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
	@OneToOne(cascade=CascadeType.ALL)
	private DateAndTime dateOfBirth;
	@Column(name="gender")
	private String gender;
	@Column(name="address")
	private String address;
	@Column(name="passportNumber")
	private String passportNumber;
	public Passenger()
	{
		this.name="";
		this.dateOfBirth=null;
		this.gender ="" ;
		this.address ="";
		this.passportNumber="";
	}
	public Passenger(String name, DateAndTime dateOfBirth, String gender, String address, String passportNumber)
	{
		this.name=name;
		this.dateOfBirth=dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.passportNumber=passportNumber;
		PersistenceFactory.getHandler().save(this);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DateAndTime getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(DateAndTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
}
