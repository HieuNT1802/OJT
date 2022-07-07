package fa.training.dao;

import fa.training.utils.JdbcConnection;
import fa.training.entities.LineItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LineItemDaoImpl implements  LineItemDAO{
    @Override
    public List<LineItem> getAllItemByOrderId(int orderId) {
        List<LineItem> lineItems = new ArrayList<LineItem>();
        try {
            Connection connection = JdbcConnection.getConnection();
            String sql = "SELECT order_id \n" +
                    "      ,product_id \n" +
                    "      ,quantity \n" +
                    "      ,price \n" +
                    "  FROM LineItem where order_id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                lineItems.add(new LineItem(
                        rs.getInt("order_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"))
                    );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lineItems;
    }

    @Override
    public void deleteLineItemByCustomerID(int customerID) {
        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("DELETE FROM LineItem WHERE order_id IN (SELECT order_id FROM Orders WHERE customer_id = ?)");
            statement.setInt(1, customerID);
            statement.executeUpdate();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public boolean addLineItem(LineItem item) {
        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO LineItem VALUES (?,?,? ?)");
            statement.setInt(1, item.getOrderId());
            statement.setInt(2, item.getProductId());
            statement.setInt(3, item.getQuantity());
            statement.setDouble(3, item.getPrice());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public double getSumByOrderID(int orderId) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String sql = "SELECT SUM(price*quantity) AS total_price FROM  LineItem  WHERE order_id = ? GROUP BY order_id";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
