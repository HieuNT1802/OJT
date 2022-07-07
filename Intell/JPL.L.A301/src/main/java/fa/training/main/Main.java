package fa.training.main;

import fa.training.utils.Validator;
import fa.training.dao.*;
import fa.training.entities.Customer;
import fa.training.entities.LineItem;
import fa.training.entities.Order;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        while (true) {

            int choice = Validator.inputInRange(0, 10);
            CustomerDAO customerDAO = new CustomerDaoImpl();
            OrderDAO orderDAO = new OrderDaoImpl();
            LineItemDAO lineItemDAO = new LineItemDaoImpl();

            switch (choice) {
                case 1:
                    System.out.println("==All customer==");
                    List<Customer> customerList = customerDAO.getAllCustomer();
                    customerList.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("==Input Customer ID==");
                    int cusId = Validator.checkInputInt();
                    List<Order> orderList = orderDAO.getAllOrderByCustomerId(cusId);
                    if (orderList != null) {
                        System.out.println("==All Orders of customer have ID = " + cusId + "==");
                        orderList.forEach(System.out::println);
                    } else {
                        System.out.println("This customer have no order");
                    }

                    break;
                case 3:
                    System.out.println("==Input order ID==");
                    int orderId = Validator.checkInputInt();
                    List<LineItem> lineItemList = lineItemDAO.getAllItemByOrderId(orderId);
                    if (lineItemList != null) {
                        System.out.println("==All LineItem of orderId  = " + orderId + "==");
                        lineItemList.forEach(System.out::println);
                    } else {
                        System.out.println("orderId  = " + orderId + " Do not have any Line Item");
                    }

                    break;
                case 4:
                    System.out.println("==Input order ID==");
                    orderId = Validator.checkInputInt();
                    double total = lineItemDAO.getSumByOrderID(orderId);
                    if (total != 0) {
                        System.out.println("==Total price LineItem of orderId  = " + orderId + " is " + total);
                    } else {
                        System.out.println("orderId  = " + orderId + " Do not have any Line Item");
                    }
                    break;
                case 5:
                    System.out.println("==Add Customer==");
                    Customer cus = new Customer();
                    System.out.println("Input customer name :");
                    String cusName = Validator.inputString();
                    cus.setCustomerName(cusName);

                    if (customerDAO.addCustomer(cus)) {
                        System.out.println("Insert successfully!");
                    } else {
                        System.out.println("Insert Fail");
                    }

                    break;
                case 6:
                    System.out.println("==Delete Customer==");
                    System.out.println("Input customer ID want to delete :");
                    int deleteCusId = Validator.checkInputInt();
                    if (customerDAO.deleteCustomer(deleteCusId)) {
                        System.out.println("Delete successfully!");
                    } else {
                        System.out.println("Delete Fail");
                    }
                    break;
                case 7:
                    System.out.println("==Update Customer==");
                    System.out.println("Input customer ID want to Update :");
                    Customer updateCus = Validator.checkExitsCustomer();
                    String newName = Validator.inputString();
                    updateCus.setCustomerName(newName);
                    if (customerDAO.updateCustomer(updateCus)) {
                        System.out.println("Update successfully");
                    } else {
                        System.out.println("Update Fail");
                    }
                    break;
                case 8:
                    Order order = new Order();
                    System.out.println("Input customer ID");
                    int customerID = Validator.checkExitsCustomer().getCustomerId();
                    System.out.println("Input employee ID");
                    int empID = Validator.checkInputInt();
                    System.out.println("Input Total price");
                    double totalPrice = Validator.isDouble();
                    order.setCustomerId(customerID);
                    order.setEmployeeId(empID);
                    order.setTotal(totalPrice);
                    if (orderDAO.addOrder(order)) {
                        System.out.println("Insert successfully!");
                    }
                    else {
                        System.out.println("Insert Fail");
                    }
                    break;
                case 9:
                    LineItem lineItem = new LineItem();
                    System.out.println("Input order ID");
                    int lOrderId = Validator.checkInputInt();
                    System.out.println("Input Product ID");
                    int lProductId = Validator.checkInputInt();
                    System.out.println("Input Quantity");
                    int quantity = Validator.checkInputInt();
                    System.out.println("Input Pirce of item");
                    double price = Validator.isDouble();
                    lineItem.setOrderId(lOrderId);
                    lineItem.setProductId(lProductId);
                    lineItem.setQuantity(quantity);
                    lineItem.setPrice(price);
                    if (lineItemDAO.addLineItem(lineItem)) {
                        System.out.println("Insert successfully!");
                    }
                    else {
                        System.out.println("Insert Fail");
                    }
                    break;
                default:
                    return;
            }
        }
    }
}

