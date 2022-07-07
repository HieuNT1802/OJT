package fa.training.dao;

import fa.training.utils.JdbcConnection;
import fa.training.entities.Order;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDAO {


    @Override
    public List<Order> getAllOrderByCustomerId(int customerID) {
        List<Order> listOrders = new ArrayList<Order>();
        try {
            Connection connection = JdbcConnection.getConnection();
            String sql = "SELECT  [order_id]\n" +
                    "      ,[order_date]\n" +
                    "      ,[customer_id]\n" +
                    "      ,[employee_id]\n" +
                    "      ,[total]\n" +
                    "  FROM Orders where customer_id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, customerID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                listOrders.add(new Order(
                        rs.getInt("order_id"),
                        rs.getDate("order_date"),
                        rs.getInt("customer_id"),
                        rs.getInt("employee_id"),
                        rs.getDouble("total")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOrders;
    }

    @Override
    public void deleteOrderByCustomerID(int customerID) {
        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("DELETE From Order WHERE customer_id = ?");
            statement.setInt(1, customerID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean addOrder(Order order) {
        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO Orders VALUES (?,?,?,?)");
            statement.setDate(1, Date.valueOf(LocalDate.now()));
            statement.setInt(2, order.getCustomerId());
            statement.setInt(3, order.getEmployeeId());
            statement.setDouble(4, order.getTotal());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}


