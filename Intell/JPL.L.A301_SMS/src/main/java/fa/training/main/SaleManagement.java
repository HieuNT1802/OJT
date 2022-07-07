package fa.training.main;

import fa.training.dao.*;
import fa.training.entities.Customer;
import fa.training.entities.LineItem;
import fa.training.entities.Order;
import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SaleManagement {
    public static void main(String[] args) throws SQLException {
        OrderDAO orderDAO = new OrderDAOImpl();
        CustomerDAO customerDAO= new CustomerDAOImpl();
        LineItemDAO lineItemDAO = new LineItemDAOImpl();
        List<LineItem> lineItemList =  lineItemDAO.getAllItemsByOrderId(2);
        List<Customer> customerList =  customerDAO.getAll();
        List<Order> orderList = orderDAO.getAllOrdersByCustomerId(1);

        // 1,2,3
        lineItemList.forEach(System.out::println);
       // orderList.forEach(System.out::println);
        //customerList.forEach(System.out::println);

        //5
//         Customer customer = new Customer();
//         customer.setCustomerId(5);
//         customer.setCustomerName("trung");
//         boolean success = customerDAO.insert(customer);

        //6
       // boolean success = customerDAO.deleteCustomer(4);

       //7
        // boolean success = customerDAO.updateCustomer("Dong",1);

       //8

//        Order order= new Order();
//        order.setOrderId(5);
//        order.setOrderDate(LocalDate.now().minusYears(18));
//        order.setCustomerId(1);
//        order.setEmployeeId(2);
//        order.setTotal(102392);
//        boolean success = orderDAO.addOrder(order);

        //9
//        LineItem lineItem = new LineItem();
//        lineItem.setOrderId(1);
//        lineItem.setProductId(3);
//        lineItem.setQuantity(1);
//        lineItem.setPrice(132059);
//        boolean sucess = lineItemDAO.addLineItem(lineItem);
        //10
        //boolean sucess = orderDAO.updateOrderTotal(1);
    }
}
