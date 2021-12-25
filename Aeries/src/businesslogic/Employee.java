package businesslogic;

import utilities.*;
import javax.persistence.*;
@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int empID;
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	private DateAndTime dateOfBirth;
	@Column(name="gender")
	private String gender;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="position")
	private String position;
	
	public Employee(int id, String name, DateAndTime dateOfBirth, String gender, String email, String password,String position)
	{
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.position=position;
		this.password = password;
		PersistenceFactory.getHandler().save(this);
	}
	public boolean authenticateUser(String email, String password)
	{
		if(this.email.equals(email) && this.password.equals(password))
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPosition() {
		return position;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Dummy comment
}
