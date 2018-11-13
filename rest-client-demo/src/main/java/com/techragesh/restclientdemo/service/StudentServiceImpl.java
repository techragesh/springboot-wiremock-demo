package com.techragesh.restclientdemo.service;

import com.techragesh.restclientdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    RemoteStudentServiceClient remoteStudentServiceClient;

    public List<Student> getAllStudents() {
        return remoteStudentServiceClient.getAllStudents();
    }
}
