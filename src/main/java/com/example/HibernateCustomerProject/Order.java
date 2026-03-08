package com.example.HibernateCustomerProject;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderNumber;
    private String productName;
    private int quantity;
    private double price;
    private LocalDate orderDate;

    @OneToOne(mappedBy = "order")
    private Customer customer;

    public Order() {}

    public Order(String orderNumber, String productName,
                 int quantity, double price, LocalDate orderDate) {

        this.orderNumber = orderNumber;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}