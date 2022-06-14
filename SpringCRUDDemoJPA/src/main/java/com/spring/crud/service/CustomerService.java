package com.spring.crud.service;

import com.spring.crud.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();


    public Customer getCustomerById(int id);

    public void saveCustomer(Customer customer);

    public void deleteCustomerById(int id);
}
