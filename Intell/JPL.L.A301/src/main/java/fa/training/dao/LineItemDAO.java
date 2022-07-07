package fa.training.dao;

import fa.training.entities.LineItem;

import java.util.List;

public interface LineItemDAO {
    List<LineItem> getAllItemByOrderId(int orderId);

    void deleteLineItemByCustomerID(int customerID);

    boolean addLineItem(LineItem item);

    double getSumByOrderID(int orderId);


}
