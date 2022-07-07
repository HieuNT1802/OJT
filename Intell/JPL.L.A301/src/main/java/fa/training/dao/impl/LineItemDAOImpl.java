package fa.training.dao.impl;

import fa.training.dao.LineItemDAO;
import fa.training.entities.LineItem;
import fa.training.utils.ConnectionUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineItemDAOImpl extends ConnectionUtil implements LineItemDAO {

    private static final String SELECT_ALL = "SELECT * FROM LineItem Where order_id = ?";
    private static final String COMPUTE_ORDER_TOTAL = "SELECT * FROM dbo.computeOrderTotal(?)";
    private static final String INSERT = "INSERT INTO LineItem (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";


    @Override
    public List<LineItem> getAll() throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public List<LineItem> getALlByID(int id) throws SQLException {
        List<LineItem> lineItemList = new ArrayList<>();
        rs = executeQuery(SELECT_ALL, id);
        while (rs.next()) {
            lineItemList.add(new LineItem(rs.getInt("order_id"),
                    rs.getInt("product_id"),
                    rs.getInt("quantity"),
                    rs.getDouble("price")));
        }
        return lineItemList;
    }

    @Override
    public boolean update(LineItem lineItem) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean checkExits(int id) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean add(LineItem lineItem) throws SQLException {
        int orderId = lineItem.getOrderId();
        int productId = lineItem.getProductId();
        int quantity = lineItem.getQuantity();
        double price = lineItem.getPrice();
        return executeUpdate(INSERT, orderId, productId, quantity, price);
    }

    @Override
    public double computeOrderTotal(int id) throws SQLException {
        double total = 0;
        rs = executeQuery(COMPUTE_ORDER_TOTAL, id);
        while(rs.next()){
            total = rs.getDouble(2);
        }
        return total;
    }
}
