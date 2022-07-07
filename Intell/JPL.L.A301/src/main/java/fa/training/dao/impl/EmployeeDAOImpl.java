package fa.training.dao.impl;

import fa.training.dao.EmployeeDAO;
import fa.training.entities.Employee;
import fa.training.utils.ConnectionUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDAOImpl extends ConnectionUtil implements EmployeeDAO {
    private static final String SELECT_ALL = "SELECT * FROM Employee";
    private static final String INSERT = "INSERT INTO Employee(employee_id, employee_name, salary, supervisor_id) VALUES (?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM Employee WHERE employee_id = ?";
    private static final String UPDATE = "UPDATE Customer SET employee_name = ?,  salary = ? , supervisor_id = ? WHERE employee_id = ?";
    private static final String CHECK_EXITS = "SELECT employee_id FROM Employee WHERE employee_id = ?";

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        rs = executeQuery(SELECT_ALL);
        while (rs.next()) {
            employeeList.add(new Employee(rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getInt(4)));
        }
        return employeeList;
    }

    @Override
    public List<Employee> getALlByID(int id) throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        int employeeId = employee.getEmployeeId();
        String employeeName = employee.getEmployeeName();
        double salary = employee.getSalary();
        int supervisorId = employee.getSupervisorId();
        return executeUpdate(UPDATE, employeeName, salary, supervisorId, employeeId);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return executeUpdate(DELETE, id);
    }

    @Override
    public boolean checkExits(int id) throws SQLException {
        int checkId;
        result = false;
        rs = executeQuery(CHECK_EXITS, id);
        while (rs.next()) {
            checkId = rs.getInt(1);
            if (checkId == id) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean add(Employee employee) throws SQLException {
        int employeeId = employee.getEmployeeId();
        String employeeName = employee.getEmployeeName();
        double salary = employee.getSalary();
        int supervisorId = employee.getSupervisorId();
        return executeUpdate(INSERT, employeeId, employeeName, salary, supervisorId);
    }

}
