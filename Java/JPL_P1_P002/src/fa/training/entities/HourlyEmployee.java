package fa.training.entities;

public class HourlyEmployee extends Employee {

	private double wage;
	private double workingHours;

	public HourlyEmployee() {}
	public HourlyEmployee(String ssn, String firstName, String lastName, String phone, String birthDate, String email, double wage, double workingHours) {
		super(ssn, firstName, lastName, phone, birthDate, email);
		this.wage = wage;
		this.workingHours = workingHours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	@Override
	public void display() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "HourlyEmployee{" +
				"wage=" + wage +
				", workingHours=" + workingHours +
				", ssn='" + ssn + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", phone='" + phone + '\'' +
				", birthDate='" + birthDate + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
