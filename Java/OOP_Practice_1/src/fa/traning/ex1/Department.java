package fa.traning.ex1;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private String location;
    private List<Employee> employees;

    public Department(String name, String location, List<Employee> employees) {
        this.name = name;
        this.location = location;
        this.employees = employees;
    }

    public Department() {
        this("unknown", "unknown", new ArrayList<>());
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public boolean addEmployee(Employee employee) {
        return this.employees.add(employee);
    }

    public boolean removeEmployee(Employee employee) {
        return this.employees.remove(employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public double getYearlyExpenditure () {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum * 12;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                "}\nemployees=" + employees +
                '}';
    }
}
