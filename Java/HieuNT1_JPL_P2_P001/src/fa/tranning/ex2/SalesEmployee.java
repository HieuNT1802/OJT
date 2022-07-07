package fa.tranning.ex2;

import java.util.Date;

public class SalesEmployee extends Employee {

	public SalesEmployee() {
		// TODO Auto-generated constructor stub
	}

	public SalesEmployee(String ssn, String firstName, String lastName, String address, Date birthDate, String phone,
			String email) {
		super(ssn, firstName, lastName, address, birthDate, phone, email);
		// TODO Auto-generated constructor stub
	}
  public double getSalary() {
	return 0;
	  
  }
}
