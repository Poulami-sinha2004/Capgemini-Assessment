package com.example.HibernateCustomerProject;

import jakarta.persistence.*;

public class OrderDAOImpl {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("customerPU");
    EntityManager em = emf.createEntityManager();

    public Order getOrderById(int id) {
        return em.find(Order.class, id);
    }

    public void updateOrder(Order order) {

        em.getTransaction().begin();

        em.merge(order);

        em.getTransaction().commit();
    }
}