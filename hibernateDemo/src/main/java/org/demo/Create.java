package org.demo;


import org.entity.Department;
import org.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create
{
    public static void main( String[] args )
    {
        //session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Department.class).buildSessionFactory();

        //session
        Session session=factory.getCurrentSession();

        try {
            Department department = new Department("EEE");
            Student student = new Student("john", "oslen", "john.oslen@gmail.com", department);
            //begin transaction
            session.beginTransaction();
            //save
            session.save(student);
            //commit
            session.getTransaction().commit();
            System.out.println("saved in database");
        }
        finally {
            factory.close();
        }

    }
}
