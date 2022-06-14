package com.spring.crud.service;

import com.spring.crud.dao.CustomerDao;
import com.spring.crud.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomerById(int id) {
        customerDao.deleteCustomerById(id);
    }
}
