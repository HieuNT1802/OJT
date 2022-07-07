package fa.training.dao;

import fa.training.utils.JdbcConnection;
import fa.training.entities.Customer;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDAO {
    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new LinkedList<>();

        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT customer_id, customer_name FROM Customer");
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("customer_id"), rs.getString("customer_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String sql = "SELECT customer_id, customer_name FROM Customer WHERE customer_id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, customerId);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return new Customer(rs.getInt("customer_id"), rs.getString("customer_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Customer VALUES ( ?)");
            statement.setString(1, customer.getCustomerName());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        if (getCustomerById(customerId) == null) {
            return false;
        }
        try (Connection connection = JdbcConnection.getConnection()) {
            LineItemDAO lineItemDAO = new LineItemDaoImpl();
            OrderDAO orderDAO = new OrderDaoImpl();
            lineItemDAO.deleteLineItemByCustomerID(customerId);
            orderDAO.deleteOrderByCustomerID(customerId);
            PreparedStatement statement = connection.prepareStatement("DELETE From Customer WHERE customer_id = ?");
            statement.setInt(1, customerId);
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        if (getCustomerById(customer.getCustomerId()) == null) {
            return false;
        }
        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE Customer SET customer_name = ? WHERE customer_id = ?");
            statement.setString(1, customer.getCustomerName());
            statement.setInt(2, customer.getCustomerId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
