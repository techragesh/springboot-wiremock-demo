package com.techragesh.restservicedemo.service;


import com.techragesh.restservicedemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private static List<Student> studentList = new ArrayList<Student>();

    public List<Student> getStudentList() {
        return studentList =  Arrays.asList(new Student("1","peter", "texas","0001200"), new Student("2","sam", "newyork","0001100"), new Student("3","david", "newjersy","0201100"));
    }
}
