package com.example.HibernateCustomerProject;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;
    private String email;
    private String gender;
    private long phone;
    private LocalDate registrationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    public Customer() {}

    public Customer(String customerName, String email, String gender,
                    long phone, LocalDate registrationDate) {
        this.customerName = customerName;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public long getPhone() {
        return phone;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}