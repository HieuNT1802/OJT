package fa.training.controller;

import fa.training.dao.*;
import fa.training.dao.impl.*;
import fa.training.entities.Customer;
import fa.training.entities.LineItem;
import fa.training.entities.Order;
import fa.training.service.InputService;
import fa.training.utils.Constant;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SaleManagement {
    public static void main(String[] args) throws SQLException {
        List<String> listMenu = new ArrayList<>();
        Customer customer = new Customer();
        CustomerDAO customerDAO = new CustomerDAOImpl();
        OrderDAO orderDAO = new OrderDAOImpl();
        LineItemDAO lineItemDAO = new LineItemDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        ProductDAO productDAO = new ProductDAOImpl();

        int customerId;
        int orderId;
        int employeeId;
        int productId;

        listMenu.add("1 - List all customers");
        listMenu.add("2 - List all orders by customer");
        listMenu.add("3 - List all line items by order id");
        listMenu.add("4 - Compute order total");
        listMenu.add("5 - Add a customer");
        listMenu.add("6 - Delete a customer");
        listMenu.add("7 - Update a customer");
        listMenu.add("8 - Create an order");
        listMenu.add("9 - Create a line item");
        listMenu.add("10 - Update an order total");
        listMenu.add("0 - Exit");
        boolean exit = false;
        int choice;
        do {
            choice = InputService.getChoice(listMenu);
            switch (choice) {
                case 1:
                    customerDAO.getAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter customer id: ");
                    customerId = InputService.createIntValue();
                    orderDAO.getAllByCustomerId(customerId).forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter order id: ");
                    orderId = InputService.createIntValue();
                    lineItemDAO.getALlByID(orderId).forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter order id: ");
                    orderId = InputService.createIntValue();
                    System.out.printf("Total Order id : %d  = %.2f $\n", orderId, lineItemDAO.computeOrderTotal(orderId));
                    lineItemDAO.computeOrderTotal(orderId);
                    break;
                case 5:
                    customer.createCustomer();
                    if (!customerDAO.checkExits(customer.getCustomerId())) {
                        if (customerDAO.add(customer)) {
                            System.out.println(Constant.ADD_SUCCESS);
                        } else {
                            System.out.println(Constant.FAILURE_ADD_CUSTOMER);
                        }
                    } else {
                        System.out.println(Constant.EXIST_CUSTOMER_ID);
                    }
                    break;
                case 6:
                    System.out.print("Enter customer id : ");
                    customerId = InputService.createIntValue();
                    if (customerDAO.delete(customerId)) {
                        System.out.println(Constant.DELETE_SUCCESS);
                    } else {
                        System.out.println(Constant.NOT_EXIST_CUSTOMER_ID);
                    }
                    break;
                case 7:
                    customer.createCustomer();
                    if (customerDAO.checkExits(customer.getCustomerId())) {
                        if (customerDAO.update(customer)) {
                            System.out.println(Constant.UPDATE_SUCCESS);
                        } else {
                            System.out.println(Constant.FAILURE_UPDATE_CUSTOMER);
                        }
                    } else {
                        System.out.println(Constant.EXIST_CUSTOMER_ID);
                    }
                    break;
                case 8:
                    System.out.print("Enter date: ");
                    LocalDate date = InputService.inputDate();
                    System.out.print("Enter customer id: ");
                    customerId = InputService.createIntValue();
                    System.out.print("Enter employee id: ");
                    employeeId = InputService.createIntValue();
                    if (customerDAO.checkExits(customerId) && employeeDAO.checkExits(employeeId)) {
                        int id = orderDAO.addOrder(new Order(Date.valueOf(date), customerId, employeeId));
                        if (id > 0) {
                            System.out.println(Constant.ADD_SUCCESS + "\nOrder id = " + id);
                        } else {
                            System.out.println(Constant.FAILURE_ADD_ORDER);
                        }
                    } else {
                        System.out.println("Customer id or Employee id not available");
                    }
                    break;
                case 9:
                    System.out.print("Enter order id: ");
                    orderId = InputService.createIntValue();
                    System.out.print("Enter product id: ");
                    productId = InputService.createIntValue();
                    System.out.print("Enter quantity: ");
                    int quantity = InputService.createIntValue();
                    System.out.print("Enter price: ");
                    double price = InputService.createDoubleValue();
                    if (orderDAO.checkExits(orderId) && productDAO.checkExits(productId)) {
                        if (lineItemDAO.add(new LineItem(orderId, productId, quantity, price))) {
                            System.out.println(Constant.ADD_SUCCESS);
                        } else {
                            System.out.println(Constant.FAILURE_ADD_LINEITEM);
                        }
                    } else {
                        System.out.println("Order id or Product id not available");
                    }
                    break;
                case 10:
                    System.out.print("Enter order id : ");
                    orderId = InputService.createIntValue();
                    if (orderDAO.updateTotal(orderId)) {
                        System.out.println("Update success");
                    } else {
                        System.out.println("Failed update");
                    }
                    break;
                case 0:
                    exit = true;
                    break;
            }
            if (exit) {
                break;
            }
        } while ((choice > 0) && (choice <= 11));
    }
}
