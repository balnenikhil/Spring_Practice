package org.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class BankDAO {
    public String  addBank(){

        System.out.println(getClass()+": doing my DB work: Bank Account");
         return "nikhil";
    }

    public boolean  sampleBank(){
        System.out.println(getClass()+": in sample bank");
        return false;
    }
}
