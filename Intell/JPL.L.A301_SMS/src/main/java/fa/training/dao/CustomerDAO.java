package fa.training.dao;

import fa.training.entities.Customer;
import java.sql.SQLException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    List<Customer> getAll() throws SQLException;

    boolean insert(Customer customer) throws  SQLException;

    //boolean updateCustomer(int cusID) throws  SQLException;

    boolean updateCustomer(String cusName, int cusID) throws SQLException;

    boolean deleteCustomer(int cusId) throws SQLException;
}
