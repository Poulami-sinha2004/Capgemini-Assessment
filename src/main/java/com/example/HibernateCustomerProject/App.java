package com.example.HibernateCustomerProject;

import java.time.LocalDate;
import java.util.List;

public class App {

    public static void main(String[] args) {

        CustomerDAOImpl customerDao = new CustomerDAOImpl();
        OrderDAOImpl orderDao = new OrderDAOImpl();

        // INSERT CUSTOMER WITH ORDER
        Order order = new Order(
                "ORD101",
                "Laptop",
                1,
                75000,
                LocalDate.now()
        );

        Customer customer = new Customer(
                "Poulami",
                "poulami@gmail.com",
                "Female",
                9876543210L,
                LocalDate.now()
        );

        customer.setOrder(order);
        order.setCustomer(customer);

        customerDao.insertCustomer(customer);

        System.out.println("Customer inserted successfully!");


        // FETCH CUSTOMER BY ID
        Customer fetchedCustomer = customerDao.getCustomerById(1);

        if (fetchedCustomer != null) {
            System.out.println("Fetched Customer: " + fetchedCustomer.getCustomerName());
        }


        // UPDATE CUSTOMER
        if (fetchedCustomer != null) {

            fetchedCustomer.setEmail("updatedemail@gmail.com");

            customerDao.updateCustomer(fetchedCustomer);

            System.out.println("Customer updated successfully!");
        }


        // FETCH ALL CUSTOMERS
        List<Customer> customers = customerDao.getAllCustomers();

        System.out.println("All Customers:");

        for (Customer c : customers) {
            System.out.println(c.getCustomerName() + " - " + c.getEmail());
        }


        // JPQL QUERY (FETCH BY EMAIL)
        Customer emailCustomer = customerDao.getCustomerByEmail("updatedemail@gmail.com");

        if (emailCustomer != null) {
            System.out.println("Customer fetched by email: " + emailCustomer.getCustomerName());
        }


        // FETCH ORDER BY ID
        Order fetchedOrder = orderDao.getOrderById(1);

        if (fetchedOrder != null) {
            System.out.println("Order Product: " + fetchedOrder.getProductName());
        }


        // UPDATE ORDER
        if (fetchedOrder != null) {

            fetchedOrder.setPrice(80000);

            orderDao.updateOrder(fetchedOrder);

            System.out.println("Order updated successfully!");
        }


        // DELETE CUSTOMER
        customerDao.deleteCustomer(1);

        System.out.println("Customer deleted successfully!");
    }
}