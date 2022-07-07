package fa.training.dao;
import java.sql.*;
import fa.training.common.DatabaseConnection;
import fa.training.entities.Customer;
import fa.training.entities.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.sql.Date;

public class OrderDAOImpl implements OrderDAO{
    @Override
    public List<Order> getAllOrdersByCustomerId(int customerId) {
        List<Order> ordersList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Orders WHERE customer_id = ?");
            preparedStatement.setInt(1, customerId);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                LocalDate dateOfBirth = rs.getDate(2).toLocalDate() ;
                int cusid = rs.getInt(3);
                int emid = rs.getInt(4);
                double total = rs.getDouble(5);
                Order order = new Order(id,dateOfBirth,cusid,emid,total);
                ordersList.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ordersList;
    }

    @Override
    public boolean addOrder(Order order) throws SQLException  {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO Orders VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, order.getOrderId());
            statement.setDate(2, java.sql.Date.valueOf(order.getOrderDate()));
            statement.setInt(3, order.getCustomerId());
            statement.setInt(4, order.getEmployeeId());
            statement.setDouble(5, order.getTotal());
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateOrderTotal(int orderId) throws SQLException {
        double d = 100000;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE Orders SET total = ? WHERE order_id = ?;");
            statement.setDouble(1,d);
            statement.setInt(2,orderId);

            return statement.executeUpdate() > 0;
        }
    }
}
