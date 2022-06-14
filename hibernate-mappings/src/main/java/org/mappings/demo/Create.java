package org.mappings.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mappings.entity.Course;
import org.mappings.entity.Instructor;
import org.mappings.entity.Student;

import java.util.ArrayList;

public class Create
{
    public static void main( String[] args )
    {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

        //session
        Session session=factory.getCurrentSession();

        try {
            session.beginTransaction();
            /*creating students
            Student student = new Student("nikhil", "balne", "balne.nikhil@gmail.com");
            saving students to db
            session.save(student); */

            //adding courses to students
            /*Student student = session.get(Student.class, 1);
            Course course1 = new Course("java", "introduction to java");
            Course course2 = new Course("python", "introduction to python");
            student.addCourse(course1);
            student.addCourse(course2);
            //saving courses to db
            session.save(course1);
            session.save(course2); */

            Student student =session.get(Student.class, 1);
            Course course= session.get(Course.class, 3);
            student.addCourse(course);
            session.save(student);
            //commit
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }
}
