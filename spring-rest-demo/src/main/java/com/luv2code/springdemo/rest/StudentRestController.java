package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class StudentRestController {

    @GetMapping("students")
    public List<Student> listStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Pierrot", "Mongonnam"));
        students.add(new Student("Elke", "Borgmann"));
        students.add(new Student("Odile", "Baima"));
        return students;
    }
}
