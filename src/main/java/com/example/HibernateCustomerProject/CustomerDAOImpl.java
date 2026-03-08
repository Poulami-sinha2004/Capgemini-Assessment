package com.example.HibernateCustomerProject;

import java.util.List;

import jakarta.persistence.*;

public class CustomerDAOImpl {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("customerPU");
    EntityManager em = emf.createEntityManager();

    public void insertCustomer(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    public void updateCustomer(Customer customer) {
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }

    public void deleteCustomer(int id) {

        em.getTransaction().begin();

        Customer c = em.find(Customer.class, id);

        if (c != null) {
            em.remove(c);
        }

        em.getTransaction().commit();
    }

    public Customer getCustomerById(int id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> getAllCustomers() {

        TypedQuery<Customer> query =
                em.createQuery("SELECT c FROM Customer c", Customer.class);

        return query.getResultList();
    }

    public Customer getCustomerByEmail(String email) {

        TypedQuery<Customer> query =
                em.createQuery("SELECT c FROM Customer c WHERE c.email = :email", Customer.class);

        query.setParameter("email", email);

        List<Customer> list = query.getResultList();

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }
}