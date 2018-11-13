package com.techragesh.restservicedemo.resource;

import com.techragesh.restservicedemo.model.Student;
import com.techragesh.restservicedemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all-students")
    public List<Student> getAllStudents() {
        return studentService.getStudentList();
    }

}
