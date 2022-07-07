package fa.training.dao;

import fa.training.common.DatabaseConnection;
import fa.training.entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Customer");
            while (rs.next()) {
                int id = rs.getInt(1);
                String fullName = rs.getString(2);


                //Student student = new Student(id, fullName, dateOfBirth, mark);
                //studentList.add(student);
                Customer customer = new Customer(id,fullName);
                customerList.add(customer);
            }
        }
        return customerList;
    }

    @Override
    public boolean insert(Customer customer) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Customer VALUES (?, ?)");
            statement.setInt(1, customer.getCustomerId());
            statement.setString(2, customer.getCustomerName());
            return statement.executeUpdate() > 0;
    }
}

    @Override
    public boolean updateCustomer(String cusName, int cusID) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE Customer SET customer_name = ? WHERE customer_id = ?;");
            statement.setString(1,cusName);
            statement.setInt(2, cusID);

            return statement.executeUpdate() > 0;
    }
}

    @Override
    public boolean deleteCustomer(int cusId) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders WHERE customer_id=?\n" +
                                                                          "DELETE FROM Customer WHERE customer_id=?");
            statement.setInt(1,cusId);
            statement.setInt(2, cusId);
            return statement.executeUpdate() > 0;
        }
    }
}

