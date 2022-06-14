package org.aop.demo;

import org.aop.bean.Account;
import org.aop.dao.AccountDAO;
import org.aop.dao.BankDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopDemoApp {
    public static void main(String[] args) {
        // reading Aop config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        //getting bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        BankDAO bankDAO = context.getBean("bankDAO", BankDAO.class);

        //creating account object
        Account account = new Account();
        //calling method in  dao
        accountDAO.addAccount(account, true);
        accountDAO.sampleAccount();
        bankDAO.addBank();
        bankDAO.sampleBank();

        //closing context
        context.close();
    }
}
