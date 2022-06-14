package com.crm.controller;

import com.crm.dao.CustomerDAO;
import com.crm.entity.Customer;
import com.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){

        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "ListCustomers";
    }


    @GetMapping("/addCustomer")
    public String addCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "CustomerAddForm";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId") int customerId, Model model)
    {
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return "CustomerAddForm";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int customerId, Model model){
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }
}
