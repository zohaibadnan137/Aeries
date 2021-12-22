package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.Airline;
import businesslogic.EmployeeList;
import utilities.DateAndTime;

public class TestAuthenticateUser {
	@Test
	public void Test1() {
		EmployeeList Emp=new EmployeeList();
		DateAndTime d=new DateAndTime(2000, 07, 07, 8, 0, 0);
		Emp.addEmployee(1, "Asim Ali", d, "male", "asimaliofficial0@gmail.com", "12345", "FDO");
		Airline A=new Airline("Aeries", Emp, null, null, null, null);
		assertEquals("Asim Ali",A.authenticateUser("asimaliofficial0@gmail.com", "12345").getName());
		assertEquals(1,A.authenticateUser("asimaliofficial0@gmail.com", "12345").getId());
	}
	@Test
	public void Test2() {
		EmployeeList Emp=new EmployeeList();
		DateAndTime d=new DateAndTime(2000, 07, 07, 8, 0, 0);
		Emp.addEmployee(1, "Asim Ali", d, "male", "asimaliofficial0@gmail.com", "12345", "FDO");
		Emp.addEmployee(2, "Huzaifa", d, "male", "Huzaifa@gmail.com", "34556", "FDO");
		Emp.addEmployee(3, "Zohaib", d, "male", "Zohaib@gmail.com", "12555", "FDO");
		Emp.addEmployee(4, "Ali", d, "male", "Ali@gmail.com", "12225", "FDO");
		Emp.addEmployee(5, "adnan", d, "male", "Adnan@gmail.com", "11115", "FDO");
		Airline A=new Airline("Aeries", Emp, null, null, null, null);
		assertEquals(5,A.authenticateUser("Adnan@gmail.com", "11115").getId());
		assertEquals(3,A.authenticateUser("Zohaib@gmail.com", "12555").getId());
		assertEquals(4,A.authenticateUser("Ali@gmail.com", "12225").getId());
	}
}
