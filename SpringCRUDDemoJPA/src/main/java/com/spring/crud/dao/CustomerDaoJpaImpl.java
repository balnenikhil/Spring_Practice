package com.spring.crud.dao;

import com.spring.crud.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Primary
public class CustomerDaoJpaImpl implements CustomerDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getAllCustomers() {

        Query query = entityManager.createQuery("from Customer");
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {

        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {

        Customer customerDb =entityManager.merge(customer);

        //getting generated id from db and returning it to api
        customer.setCustomerId(customerDb.getCustomerId());

    }

    @Override
    public void deleteCustomerById(int id) {

        Query query = entityManager.createQuery("delete from Customer where customerId =: id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
