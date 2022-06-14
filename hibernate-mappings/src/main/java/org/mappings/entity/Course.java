package org.mappings.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int cid;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_title", unique = true, length = 100)
    private String courseTitle;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "course_instructor", joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id")
    )
    private List<Instructor> instructors;


    public Course() {
    }

    public Course(String courseName, String courseTitle) {
        this.courseName = courseName;
        this.courseTitle = courseTitle;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }


    //adding instructor
    public void addInstructor(Instructor instructor){
        if(instructors == null){
            instructors = new ArrayList<>();
        }
        instructors.add(instructor);
    }


    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", courseName='" + courseName + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", student=" + student +
                ", instructors=" + instructors +
                '}';
    }
}
