package org.aop.demo;

import org.aop.bean.Account;
import org.aop.dao.AccountDAO;
import org.aop.dao.BankDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class AopDemoApp {
    private static Logger logger = Logger.getLogger(AopDemoApp.class.getName());
    public static void main(String[] args) {
        // reading Aop config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        //getting bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        BankDAO bankDAO = context.getBean("bankDAO", BankDAO.class);
        //creating account object
      /*  Account account = new Account();
        account.setaId(1);
        account.setName("Nikhil");
        //calling method in  dao
        accountDAO.addAccount(account, true); */

       // bankDAO.addBank();

         // after returning example demo
        //List<Account> accounts = accountDAO.findAccounts();

        // after throwing example demo
        List<Account> accounts = null;

        try {
            boolean flag = false;
            accounts = accountDAO.findAccounts(flag);
        }
        catch (Exception exception){
            logger.info("Exception caught in main : "+ exception);
        }

        logger.info("In main : ");

        System.out.println(accounts);
        //closing context
        context.close();
    }
}
