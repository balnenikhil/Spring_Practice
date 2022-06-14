package org.rest.controller;

import org.rest.entity.Student;
import org.rest.entity.StudentErrorResponse;
import org.rest.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {

        //hard coding for basic testing later db implementation
         students = new ArrayList<>();
        students.add(new Student("Nikhil", "Chandra"));
        students.add(new Student("Nandan", "Ambati"));
        students.add(new Student("Anudeep", "Chakiri"));
    }

    // defining endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents(){

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if((studentId >= students.size()) ||(studentId < 0 )){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
        }

        return students.get(studentId);
    }

    /* handling above exception
   @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exception){

        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (Exception exception){

        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    } */
}
