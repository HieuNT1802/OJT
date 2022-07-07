package fa.tranning.ex2;

import java.util.Date;

public class HourlyEmployee extends Employee {
     private double rate;
     private double workingHours;
	public HourlyEmployee(String ssn, String firstName, String lastName, String address, Date birthDate, String phone,
			String email, double rate, double workingHours) {
		super(ssn, firstName, lastName, address, birthDate, phone, email);
		this.rate = rate;
		this.workingHours = workingHours;
	}
	public HourlyEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HourlyEmployee [rate=" + rate + ", workingHours=" + workingHours + "]";
	}
	
	
	

	

}
