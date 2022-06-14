package org.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int did;

    @Column(name = "dept_name")
    private String name;

    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private Student student;


    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + did +
                ", name='" + name + '\'' +
                '}';
    }
}
