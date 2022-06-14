package com.beans;

import com.validators.EmployeeId;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;


public class Employee {


    @EmployeeId
    private String id;
    @NotNull(message = "is required")
    @Size(min=3, message = "Minimum 3 letters are required")
    private String firstName;
    @NotNull(message = "is required")
    @Size(min=3, message = "Minimum 3 letters are required")
    private String lastName;

    private String password;
    private String language;
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "not a valid email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private ArrayList<String> plan;

    public ArrayList<String> getPlan() {
        return plan;
    }

    public void setPlan(ArrayList<String> plan) {
        this.plan = plan;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Employee() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
