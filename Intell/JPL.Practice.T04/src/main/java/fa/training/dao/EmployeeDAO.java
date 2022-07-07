package fa.training.dao;

import fa.training.entities.Employee;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll() throws SQLException;
    boolean save(Employee employee) throws SQLException;
    boolean update(Employee employee) throws SQLException;

    Employee findById(int emp_no) throws SQLException;
    List<Employee> findByWorkTime(Date fromDate,Date toDate) throws SQLException;
}
