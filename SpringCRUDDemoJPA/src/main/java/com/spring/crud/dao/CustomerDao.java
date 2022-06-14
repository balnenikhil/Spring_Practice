package com.spring.crud.dao;

import com.spring.crud.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(int id);

    public void saveCustomer(Customer customer);

    public void deleteCustomerById(int id);


}
