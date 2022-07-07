package fa.training.main;

import fa.training.dao.*;
import fa.training.entities.Department;
import fa.training.entities.Employee;
import fa.training.entities.Working_History;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MainTestAllFunction {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        DepartmentDAO departmentDAO = new DepartmentImpl();
        WorkingHistoryDAO workingHistoryDAO = new WorkingHistoryDAOImpl();
       //Function b. List<Employee> findAll()
        List<Employee> employeeList = employeeDAO.findAll();
        employeeList.forEach(System.out::println);

         // Function c. update(Employee employee)
        Employee employee = new Employee();
       employee.setEmpId(3);
       employee.setBirthDate(LocalDate.now().minusYears(18));
       employee.setFirstName("Nghia");
       employee.setLastName("Vu");
       employee.setGender("1");
       employee.setHireDate(LocalDate.now().minusYears(20));
        boolean suc1 = employeeDAO.update(employee);

        // Function a. save(Employee employee)
        Employee employee1 = new Employee();
        employee.setEmpId(4);
        employee.setBirthDate(LocalDate.now().minusYears(18));
        employee.setFirstName("Chien");
        employee.setLastName("Nguyen");
        employee.setGender("1");
        employee.setHireDate(LocalDate.now().minusYears(20));
        boolean suc2 = employeeDAO.update(employee);

        // Function e. save(Department department)
        Department department = new Department();
        department.setDeptName("Ha Noi");
        department.setDescription("Nice");
        boolean suc3 = departmentDAO.save(department);


        // Function d. findById(int emp_no)
        Employee employeeList1 = employeeDAO.findById(1);
        System.out.println(employeeList1);

        // Function f. findById(int emp_no)
        Working_History workingHistory = new Working_History();
        workingHistory.setEmpId(1);
        workingHistory.setDeptId(2);
        workingHistory.setFromDate(LocalDate.now().minusYears(22));
        workingHistory.setToDate(LocalDate.now().minusYears(24));
        boolean suc4 = workingHistoryDAO.save(workingHistory);

        // Function g. List<Employee> findByWorkTime(Date fromDate,Date toDate)


    }
}
