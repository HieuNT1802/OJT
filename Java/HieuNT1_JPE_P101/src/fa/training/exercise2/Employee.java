package fa.training.exercise2;

import java.security.PublicKey;

public class Employee {
  private String firstName;
  private String lastName;
  private double salary;
public Employee(String firstName, String lastName, double salary) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	if (salary>=0) {
		this.salary = salary;
	}
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public void setMonthSal( double salary) {
	if (salary>=0) {
		this.salary = salary;
	}}
	public double getMonthSalary() {
		return salary;
	}

}
