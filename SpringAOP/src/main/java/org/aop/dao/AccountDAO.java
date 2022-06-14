package org.aop.dao;

import org.aop.bean.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void  addAccount(Account account, boolean flag){

        System.out.println(getClass()+": doing my DB work: Add Account");

    }

    public boolean  sampleAccount(){
        System.out.println(getClass()+": in sample account");
        return false;
    }
}
