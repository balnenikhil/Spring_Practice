package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "Home";
    }

    @GetMapping("/teachers")
    public String organizationMeeting(){
        return "Organization";
    }

    @GetMapping("/class")
    public String classMeeting(){
        return "Class";
    }

    @GetMapping("/home")
    public String showHomePage(){
        return "Home";
    }
}
