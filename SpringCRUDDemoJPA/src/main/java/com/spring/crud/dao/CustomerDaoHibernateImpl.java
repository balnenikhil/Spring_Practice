package com.spring.crud.dao;

import com.spring.crud.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDaoHibernateImpl implements CustomerDao{

    // defining entity manager
    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Customer> getAllCustomers() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Customer> query = currentSession.createQuery("from Customer", Customer.class );

        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Customer customer = currentSession.get(Customer.class, id);

        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(customer);

    }

    @Override
    public void deleteCustomerById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Customer> query = currentSession.createQuery("delete from Customer where customerId =: id");

        query.setParameter("id",id);

        query.executeUpdate();

    }


}
