package org.mappings.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mappings.entity.Course;
import org.mappings.entity.Instructor;
import org.mappings.entity.Student;

public class CreateCourseAndInstructors {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

        //session
        Session session=factory.getCurrentSession();

        try{
            session.beginTransaction();
            Course course = new Course("Spring", "introduction to Spring");
            session.save(course);

            //create students
            Instructor instructor = new Instructor("navin reddy");
            Instructor instructor1 = new Instructor("John Doe");

            //add students
            course.addInstructor(instructor);
            course.addInstructor(instructor1);

            //save students
            session.save(instructor);
            session.save(instructor1);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
