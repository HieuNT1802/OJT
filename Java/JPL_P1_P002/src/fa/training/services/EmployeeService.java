package fa.training.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import fa.training.entities.Department;
import fa.training.entities.Employee;
import fa.training.entities.HourlyEmployee;
import fa.training.entities.SalesEmployee;

public class EmployeeService {

	private static List<Employee> employees = new LinkedList<>();

	public EmployeeService(){
		employees.add(new SalesEmployee("9123123","Long","Nguyen","18123912","18/10/2000","long@gmail.com",200));
		employees.add(new HourlyEmployee("8123123","Nam","Nguyen","18123912","18/09/2000","nam@gmail.com",91.2,9.2));
	}

	public  List<Employee> getEmployees(){
		return employees;
	}
	
	public  void display(boolean isClassified) {
		if(isClassified) {
			System.out.println("List of sales employees: ");

			for(Employee employee: employees){
				if(employee instanceof SalesEmployee){
					System.out.println(employee);
				}
			}
			System.out.println("\nList of hourly employees: ");
			for(Employee employee: employees){
				if(employee instanceof HourlyEmployee){
					System.out.println(employee);
				}
			}
		}
		else {
			for (Employee employee: employees){
				System.out.println(employee);
			}
		}
	}
	public boolean addEmployee(Employee employee) {
		return employees.add(employee);
	}
	
	public List<Employee> search(String firstName, String lastName){
		List<Employee> result = new LinkedList<>();
		for(Employee employee: employees){
			if(employee.getFirstName().equals(firstName) ||
				employee.getLastName().equals(lastName)){
					result.add(employee);
			}
		}
		return result;
	}

	public List<Employee> search(String departmentName){
		DepartmentService departmentService = new DepartmentService();
		Department department = departmentService.findDepartmentByName(departmentName);
		if(department == null){
			return null;
		}
		List<Employee> result = department.getEmployees();
		return result;
	}
}
