package fa.training.main;
import fa.training.entities.Employee;
import fa.training.utils.Service;
import fa.training.utils.Validator;
import fa.training.dao.*;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;

public class MainUserInterface {
    public static void main(String[] args) throws SQLException {
        while (true){
            int choice = Validator.inputChoice(0,7);
            DepartmentDAO departmentDAO = new DepartmentImpl();
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();
            WorkingHistoryDAO workingHistoryDAO = new WorkingHistoryDAOImpl();
            switch (choice){
                case 1:
                    Employee employee = new Employee();
                    System.out.println("----- Add a new Employee -----");
                    System.out.println("Input First Name:");
                    String empName = Validator.inputString();
                    System.out.println("Input Last Name: ");
                    String emplName = Validator.inputString();
                    System.out.println("Input Birth Date: ");
                    LocalDate bthdate= Service.inputDate();
                    System.out.println("Input Gender: ");
                    String gender = Validator.inputString();
                    System.out.println("Input Hire Date: ");
                    LocalDate hiredate= Service.inputDate();
                    employee.setFirstName(emplName);
                    employee.setLastName(emplName);
                    employee.setGender(gender);
                    employee.setBirthDate(bthdate);
                    employee.setHireDate(hiredate);
                    if (employeeDAO.save(employee)){
                        System.out.println("Add successfully!");
                    } else {
                        System.out.println("Add Fail");
                    }
                    break;
                case 2:
                    System.out.println("----- Update a specific Employee -----");
                    System.out.println();


                    break;
                case 3:
                    System.out.println("--- Find an employee by emp_no ---");
                    break;
                case 4:
                    System.out.println("---- Add the working history ----");
                    break;
                case 5:
                    System.out.println("- Find all the employees by working period of time -");
                break;
                case 6:
                    System.out.println("---- Add a new department ----");
                    break;
                default:
                    return;
            }
        }
    }
}
