package com.spring.crud.repository;

import com.spring.crud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource(path = "newCustomers")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
