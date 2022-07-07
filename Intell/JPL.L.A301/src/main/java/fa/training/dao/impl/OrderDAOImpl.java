package fa.training.dao.impl;

import fa.training.dao.LineItemDAO;
import fa.training.dao.OrderDAO;
import fa.training.entities.Order;
import fa.training.utils.ConnectionUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDAOImpl extends ConnectionUtil implements OrderDAO {
    private static final String SELECT_ORDERS_BY_CUSTOMER_ID = "SELECT * FROM Orders Where customer_id = ?";
    private static final String SELECT_ORDERS_BY_ORDER_ID = "SELECT * FROM Orders Where order_id = ?";
    private static final String INSERT_ORDER = "INSERT INTO Orders (order_date, customer_id, employee_id) VALUES (?, ?, ?)";
    private static final String CHECK_ORDER_ID = "SELECT order_id FROM Orders Where order_id = ?";
    private static final String UPDATE_TOTAL = "UPDATE Orders SET total = ? WHERE order_id = ?";

    @Override
    public List<Order> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }

    @Override
    public List<Order> getALlByID(int id) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        rs = executeQuery(SELECT_ORDERS_BY_ORDER_ID, id);
        while (rs.next()) {
            orderList.add(new Order(rs.getInt(1),
                    rs.getDate(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getDouble(5)));
        }
        return orderList;
    }

    @Override
    public boolean update(Order order) throws SQLException {
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
        int checkId;
        rs = executeQuery(CHECK_ORDER_ID, id);
        while (rs.next()) {
            checkId = rs.getInt(1);
            if (checkId == id) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean add(Order order) throws SQLException {
        return false;
    }

    @Override
    public List<Order> getAllByCustomerId(int id) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        rs = executeQuery(SELECT_ORDERS_BY_CUSTOMER_ID, id);
        while (rs.next()) {
            orderList.add(new Order(rs.getInt(1),
                    rs.getDate(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getDouble(5)));
        }
        return orderList;
    }

    @Override
    public int addOrder(Order order) throws SQLException {
        return executeUpdateForIdentity(INSERT_ORDER, order.getOrderDate(), order.getCustomerId(), order.getEmployeeId());
    }

    @Override
    public boolean updateTotal(int id) throws SQLException {
        LineItemDAO lineItemDAO = new LineItemDAOImpl();
        double total = lineItemDAO.computeOrderTotal(id);
        return executeUpdate(UPDATE_TOTAL, total, id);
    }
}
