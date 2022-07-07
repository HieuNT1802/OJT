package fa.training.exercise2;

public class EmployeeTest {
	public static void main(String[] args) {
		
	
Employee hieu = new Employee("Hieu","Nguyen",23487);
System.out.println(hieu.getFirstName() + " monthly salary is " + hieu.getMonthSalary());
hieu.setMonthSal(hieu.getMonthSalary() * 1.1);
System.out.println("Salary after 10% boost");
System.out.println(hieu.getFirstName() + " monthly salary is " + hieu.getMonthSalary());
	}}
