package org.mappings.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private int insID;

    @Column(name = "instructor_name")
    private String insNAme;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "course_instructor", joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    public Instructor() {
    }

    public Instructor( String insNAme) {
        this.insNAme = insNAme;
    }

    public String getInsNAme() {
        return insNAme;
    }

    public void setInsNAme(String insNAme) {
        this.insNAme = insNAme;
    }

    public int getInsID() {
        return insID;
    }

    public void setInsID(int insID) {
        this.insID = insID;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    //adding instructor
    public void addCourse(Course course){
        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(course);
    }
    @Override
    public String toString() {
        return "Instructor{" +
                "insID=" + insID +
                ", insNAme='" + insNAme + '\'' +
                ", courses=" + courses +
                '}';
    }
}
