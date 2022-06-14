package org.demo;

import org.entity.Department;
import org.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class delete {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Department.class).buildSessionFactory();

        //session
        Session session=factory.getCurrentSession();

        //begin transaction
        session.beginTransaction();

        //for single delete get object and use session.delete , for multiple use create query
        // for multiple delete query
        //session.createQuery("delete Student s where s.student_id='2'").executeUpdate();

        //for single delete
        Student student = session.get(Student.class, 1);
        session.delete(student);

        System.out.println("deleted");

        // commit transaction
        session.getTransaction().commit();
    }
}
