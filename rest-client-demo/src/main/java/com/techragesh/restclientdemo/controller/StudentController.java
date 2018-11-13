package com.techragesh.restclientdemo.controller;


import com.techragesh.restclientdemo.model.Student;
import com.techragesh.restclientdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

}
