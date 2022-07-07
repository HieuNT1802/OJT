package fa.training.dao;

import fa.training.entities.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Employee");
            while (rs.next()) {
                int id = rs.getInt(1);
                LocalDate dateOfBirth = rs.getDate(2).toLocalDate();
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String gender= rs.getString(5);
                LocalDate hireDate = rs.getDate(6).toLocalDate();
                Employee emplo = new Employee(id,dateOfBirth,firstName,lastName,gender,hireDate);
                employeeList.add(emplo);
            }
            return employeeList;
        }
    }

    @Override
    public boolean save(Employee employee) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO Employee VALUES ( ?, ?, ?, ?, ? )");
            //statement.setInt(1, employee.getEmpId());
            statement.setDate(1, java.sql.Date.valueOf(employee.getBirthDate()));
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getGender());
            statement.setDate(5, java.sql.Date.valueOf(employee.getHireDate()));
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("UPDATE Employee SET birth_date=?,first_name=?,last_name=?" +
                                        ",gender=?,hire_date=? WHERE emp_no=? ");

            statement.setDate(1, java.sql.Date.valueOf(employee.getBirthDate()));
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getGender());
            statement.setDate(5, java.sql.Date.valueOf(employee.getHireDate()));
            statement.setInt(6, employee.getEmpId());
            return statement.executeUpdate() > 0;
        }

    }

    @Override
    public Employee findById(int emp_no) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT emp_no,birth_date,first_name,last_name,gender,hire_date\n" +
                            "FROM Employee WHERE emp_no = ?");
            statement.setInt(1, emp_no);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return new Employee(rs.getInt("emp_no"), rs.getDate("birth_date").toLocalDate(),
                    rs.getString("first_name"),rs.getString("last_name"),rs.getString("gender")
                    ,rs.getDate("hire_date").toLocalDate());

        }
        //return null;
    }

    @Override
    public List<Employee> findByWorkTime(java.util.Date fromDate, java.util.Date toDate) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT e.emp_no,e.birth_date,e.first_name,e.last_name,e.gender,e.hire_date \n" +
                                                      "FROM Employee e INNER JOIN Working_History o ON e.emp_no = o.emp_no WHERE" +
                                                      " e.hire_date \n" +
                                                      "BETWEEN o.from_date AND o.to_date");
            while (rs.next()) {
                int id = rs.getInt(1);
                LocalDate dateOfBirth = rs.getDate(2).toLocalDate();
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String gender= rs.getString(5);
                LocalDate hireDate = rs.getDate(6).toLocalDate();
                Employee emplo = new Employee(id,dateOfBirth,firstName,lastName,gender,hireDate);
                employeeList.add(emplo);
            }
            return employeeList;
        }
    }
}