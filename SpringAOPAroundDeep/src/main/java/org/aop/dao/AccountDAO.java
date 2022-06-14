package org.aop.dao;

import org.aop.bean.Account;
import org.aop.demo.AopDemoApp;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class AccountDAO {

    public void  addAccount(Account account, boolean flag){

        System.out.println(getClass()+": doing my DB work: Add Account");

    }

    public List<Account> findAccounts(){
        List<Account> accountList = new ArrayList<>();
        Account account1 = new Account("nikhil", 2);
        Account account2 = new Account("nandan", 3);
        Account account3 = new Account("anudeep", 4);
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        return accountList;
    }

    //overloading to throw exception
    public List<Account> findAccounts(boolean flag){
        if(flag){
            throw new RuntimeException("flag exception");
        }
        List<Account> accountList = new ArrayList<>();
        Account account1 = new Account("nikhil", 2);
        Account account2 = new Account("nandan", 3);
        Account account3 = new Account("anudeep", 4);
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        return accountList;
    }

}
