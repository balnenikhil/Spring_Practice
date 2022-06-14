package org.demo;

import org.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class update {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //session
        Session session=factory.getCurrentSession();

        //begin transaction
        session.beginTransaction();

        //query
        session.createQuery("update Student s set s.firstName='john' where s.firstName like 'jhon%'").executeUpdate();


        // commit transaction
        session.getTransaction().commit();
    }
}
