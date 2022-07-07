package fa.training.services;

import java.util.LinkedList;
import java.util.List;

import fa.training.entities.Department;

public class DepartmentService {

    private static List<Department> departments = new LinkedList<>();

    public DepartmentService(){
        departments.add(new Department("FA"));
        departments.add(new Department("FLT"));
    }
    public List<Department> getDepartments() {
        return departments;
    }

    public Department findDepartmentByName(String name){
        for (Department department: departments){
            if(department.getDepartmentName().equals(name)){
                return department;
            }
        }
        return null;
    }

    public void report() {
        for (Department department : departments) {
            int empsNum = department.getEmployees().size();
            System.out.println(department.getDepartmentName() + ": " + empsNum + " employees");
        }
    }
}
