package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import com.luv2code.springdemo.entity.StudentNotFoundResponse;
import com.luv2code.springdemo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadStudentList() {
        students = new ArrayList<>();
        students.add(new Student("Pierrot", "Mongonnam"));
        students.add(new Student("Elke", "Borgmann"));
        students.add(new Student("Odile", "Baima"));
    }

    @GetMapping("students")
    public List<Student> listStudents() {
        return students;
    }

    @GetMapping("students/{studentId}")
    public Student getStudentByID(@PathVariable Integer studentId) {

        // Check if studentId in Bound of the List<Student>
        if (studentId < 0 || studentId >= students.size()){
            throw new StudentNotFoundException("Student with ID="+studentId+" not found!");
        }

        return students.get(studentId);

    }

    @ExceptionHandler
    public ResponseEntity<StudentNotFoundResponse> handleException(StudentNotFoundException exception) {
        var errorResp = new StudentNotFoundResponse();

        errorResp.setStatus(HttpStatus.NOT_FOUND.value());
        errorResp.setMessage(exception.getMessage());
        errorResp.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResp,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<StudentNotFoundResponse> handleException(Exception exception) {
        var errorResp = new StudentNotFoundResponse();

        errorResp.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResp.setMessage(exception.getMessage());
        errorResp.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResp,HttpStatus.BAD_REQUEST);

    }
}
