package com.controllers;

import com.beans.Employee;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    //Init binder to remove spaces
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    //Initial Home Page
    @RequestMapping("/")
    public String homePage(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "EmployeeHome";
    }

    //HTML Form Page
    @RequestMapping("/registration")
    public String Registration(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){
         Employee benefitEmployee = new Employee();
         model.addAttribute("benefitEmployee", benefitEmployee);
         if(bindingResult.hasErrors())
             return "EmployeeHome";
        else if(employee.getPassword().equals("qwerty12"))
            return "EmployeeForm";
        else
            return "EmployeeError";
    }

    // HTML processed form
    @RequestMapping("/processed")
    public String processedForm(@Valid @ModelAttribute("benefitEmployee") Employee benefitEmployee, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "EmployeeForm";
        else
            return "ProcessedForm";
    }

}
