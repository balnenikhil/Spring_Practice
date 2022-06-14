package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/customLoginPage")
    public String showLoginPage(){
        return "Login";
    }

    @GetMapping("/accessDeniedPage")
    public String showAccessDeniedPage(){
        return "AccessDenied";
    }
}
