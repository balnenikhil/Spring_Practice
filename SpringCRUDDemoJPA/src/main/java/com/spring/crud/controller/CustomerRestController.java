package com.spring.crud.controller;


import com.spring.crud.entity.Customer;
import com.spring.crud.exception.CustomerNotFoundException;
import com.spring.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){

        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id){

        Customer customer = customerService.getCustomerById(id);

        if(customer == null){

            throw new CustomerNotFoundException("Customer id not found - "+ id);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){

        customer.setCustomerId(0);

        customerService.saveCustomer(customer);

        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){

        customerService.saveCustomer(customer);

        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {

        Customer customer = customerService.getCustomerById(id);

        if(customer == null){
            throw new CustomerNotFoundException("Customer id not found - "+id);
        }

        customerService.deleteCustomerById(id);

        return "Deleted customer id - "+id;
    }

}
