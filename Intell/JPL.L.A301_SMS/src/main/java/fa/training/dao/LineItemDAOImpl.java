package fa.training.dao;

import fa.training.common.DatabaseConnection;
import fa.training.entities.LineItem;
import fa.training.entities.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LineItemDAOImpl implements LineItemDAO{
    @Override
    public List<LineItem> getAllItemsByOrderId(int orderId) throws SQLException  {
        List<LineItem> lineItemsList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM LineItem WHERE order_id = ?");
            preparedStatement.setInt(1, orderId);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int pid = rs.getInt(2);
                int quantity = rs.getInt(3);
                double price = rs.getDouble(4);
              //  Order order = new Order(id,dateOfBirth,cusid,emid,total);
                LineItem lineItem = new LineItem(id,pid,quantity,price);
                lineItemsList.add(lineItem);
            }
        }
        return lineItemsList;
    }

    @Override
    public boolean addLineItem(LineItem item) throws SQLException  {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO LineItem VALUES (?, ?, ?, ?)");
            statement.setInt(1, item.getOrderId());
            statement.setInt(2,item.getProductId() );
            statement.setInt(3, item.getQuantity());
            statement.setDouble(4, item.getPrice());
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public List<LineItem> getAllItemsTotal(int orderId) throws SQLException {
        List<LineItem> lineItemsList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select order_id, product_id,quantity*price\n" +
                                                                " as total_price" +
                                                                "from LineItem" +
                                                                "where order_id=? ");
            preparedStatement.setInt(1, orderId);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int pid = rs.getInt(2);
                double total = rs.getDouble(3);
                //  Order order = new Order(id,dateOfBirth,cusid,emid,total);
                //LineItem lineItem = new LineItem(id,pid,quantity,price);
                //lineItemsList.add(lineItem);
            }
        }
        return lineItemsList;
    }
}
