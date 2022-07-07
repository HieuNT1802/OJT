package fa.training.dao.impl;

import fa.training.dao.CustomerDAO;
import fa.training.entities.Customer;
import fa.training.utils.ConnectionUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDAOImpl extends ConnectionUtil implements CustomerDAO {
    private static final String SELECT_ALL = "SELECT * FROM Customer";
    private static final String INSERT = "{CALL addCustomer(?, ?)}";
    private static final String DELETE = "{CALL deleteCustomer(?)}";
    private static final String UPDATE = "{CALL updateCustomer(?, ?)}";
    private static final String CHECK_EXITS = "SELECT customer_id FROM Customer WHERE customer_id = ?";

    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        rs = executeQuery(SELECT_ALL);
        while (rs.next()) {
            customerList.add(new Customer(rs.getInt(1),
                    rs.getString(2)));
        }
        return customerList;
    }

    @Override
    public List<Customer> getALlByID(int id) throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public boolean add(Customer customer) throws SQLException {
        return executeUpdate(INSERT, customer.getCustomerId(), customer.getCustomerName());
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        return executeUpdate(UPDATE, customer.getCustomerId(), customer.getCustomerName());
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
}