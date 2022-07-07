package fa.training.management;

import java.util.List;
import java.util.Scanner;

import fa.training.entities.*;
import fa.training.services.DepartmentService;
import fa.training.services.EmployeeService;
import fa.training.utils.ValidationUtils;

public class EmployeeManagement {

	private static String title = "Employee Management System";

	private static EmployeeService employeeService = new EmployeeService();
	private static DepartmentService departmentService = new DepartmentService();
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("===" + title + "===");
		showMenu();
		int choice = 0;
		do {
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				Employee employee = inputEmployee();
				if(employeeService.addEmployee(employee)) {
					System.out.println("Add employee successfully");
				}
				break;
			case 2:
				employeeService.display(false);
				break;
			case 3:
				employeeService.display(true);
				break;
			case 4:
				System.out.println("Enter first name: ");
				String firstName = scanner.nextLine();

				System.out.println("Enter last name: ");
				String lastName = scanner.nextLine();

				List<Employee> employees = employeeService.search(firstName,lastName);
				employees.forEach(System.out::println);
				break;
			case 5:
				departmentService.report();
				break;
			case 6:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 6);
		scanner.close();
	}

	private static void showMenu() {
		System.out.println("1. Add an employee");
		System.out.println("2. Display employees");
		System.out.println("3. Classify employees");
		System.out.println("4. Search employees");
		System.out.println("5. Show report");
		System.out.println("6. Quit");
	}

	private static Employee inputEmployee() {
		
		Employee employee = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Sales");
		System.out.println("2. Hourly");
		System.out.println("Enter your employee type: ");
		
		int type = Integer.parseInt(scanner.nextLine());
		if (type == 1 || type == 2) {

			System.out.println("Enter ssn: ");
			String ssn = scanner.nextLine();

			System.out.println("Enter first name: ");
			String firstName = scanner.nextLine();

			System.out.println("Enter last name: ");
			String lastName = scanner.nextLine();

			System.out.println("Enter phone: ");
			String phone = scanner.nextLine();
			while (!ValidationUtils.isPhoneNumber(phone)){
				System.out.println("Invalid phone! Enter again");
				phone = scanner.nextLine();
			}

			System.out.println("Enter birth date: ");
			String birthDate = scanner.nextLine();
			while (!ValidationUtils.isDate("dd/MM/yyyy",birthDate)){
				System.out.println("Invalid date! Enter again");
				birthDate = scanner.nextLine();
			}

			System.out.println("Enter email: ");
			String email = scanner.nextLine();
			while (!ValidationUtils.isEmail(email)){
				System.out.println("Invalid email! Enter again");
				email = scanner.nextLine();
			}

			if (type == 1) {
				System.out.println("Enter number of unit sell: ");
				int numberOfUnitSell = Integer.parseInt(scanner.nextLine());
				employee = new SalesEmployee(ssn, firstName, lastName, phone, birthDate, email,numberOfUnitSell);

			} else if (type == 2) {
				System.out.println("Enter wage: ");
				double wage = Double.parseDouble(scanner.nextLine());

				System.out.println("Enter working hours: ");
				double workingHours = Double.parseDouble(scanner.nextLine());
	
				employee = new HourlyEmployee(ssn, firstName, lastName, phone, birthDate, email,wage,workingHours);
			}

		} else {
			System.out.println("Employee type not found");
		}

		List<Department> departments = departmentService.getDepartments();
		for (int i = 0; i < departments.size(); i++) {
			System.out.println(i + "." + departments.get(i).getDepartmentName());
		}
		System.out.println("Enter department: ");
		int dpm = 0;
		do{
			dpm = Integer.parseInt(scanner.nextLine());
			if(dpm < 0 || dpm >= departments.size()){
				System.out.println("Invalid department");
			}
		}while (dpm < 0 || dpm >= departments.size());
		departments.get(dpm).getEmployees().add(employee);
		return employee;
	}

}
