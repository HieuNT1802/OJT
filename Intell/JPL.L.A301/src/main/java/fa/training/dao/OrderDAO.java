package fa.training.dao;

import fa.training.entities.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAllOrderByCustomerId(int customerID);

    void deleteOrderByCustomerID(int customerID);

    boolean addOrder(Order order);
}
