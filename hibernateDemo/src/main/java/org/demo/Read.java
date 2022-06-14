package org.demo;

import org.entity.Department;
import org.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Read {
    public static void main(String[] args) {

        //session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Department.class).buildSessionFactory();

        //session
        Session session=factory.getCurrentSession();

        //begin transaction
        session.beginTransaction();

        //read and print a single data from database using PK
        Student student = session.get(Student.class, 2);
        System.out.println("only one student"+student);

       // System.out.println("all students using session.create query");

        // Create Query Can be used for all operations
        //List<Student> students = session.createQuery("from Student").getResultList();
        //display(students);

       // System.out.println("students with first name containing jhon");
       // List<Student> sameFirstNameStudents = session.createQuery("from Student s where s.firstName='jhon' OR s.firstName='jhonny'").getResultList();
       // display(sameFirstNameStudents);

        Department department = session.get(Department.class, 2);
        System.out.println(department.getStudent());


        // commit transaction
        session.getTransaction().commit();
    }

    private static void display(List<Student> students) {
        for(Student tempStudent: students){
            System.out.println(tempStudent);
        }
    }
}
