package org.example;
import org.beans.*;
import org.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       context.refresh();
       //spring configuration
      Phone motorola = context.getBean("Phone", Phone.class);
      System.out.println(motorola.getSpecifications());

       //setter injection
        Phones phones = context.getBean("Phones", Phones.class);
        System.out.println(phones);

        //Java Annotations
        Employee employee = context.getBean("employee", Employee.class);
        employee.setEmployeeId(10);
        employee.setEmployeeName("nikhil");
        employee.setEmployeeSalary("300000");


        //constructor injection using Java annotations
        Company company = context.getBean("company",Company.class);
        company.setCompanyId(9);
        company.setCompanyName("zemoso");
        employee.setCompany(company);
        System.out.println(employee);

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        Alien alien = annotationConfigApplicationContext.getBean("alien", Alien.class);
        alien.setAlienId(2);
        alien.setAlienName("Bunty");
        System.out.println(alien);

        // to read values from property file and set it to variables
        //PropertySource -- to give location of property file
        //value to set value using field level


    }
}
