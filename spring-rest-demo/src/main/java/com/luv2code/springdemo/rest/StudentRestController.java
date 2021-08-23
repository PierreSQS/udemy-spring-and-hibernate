package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        Student foundStudent = null;

        if (studentId > students.size()) {
            foundStudent = new Student("Student","Not found");
        } else {
            for (Student student:students) {
                if(student.getFirstName().equals(students.get(studentId).getFirstName())){
                    foundStudent = student;
                }
            }
        }
        return foundStudent;

    }
}
