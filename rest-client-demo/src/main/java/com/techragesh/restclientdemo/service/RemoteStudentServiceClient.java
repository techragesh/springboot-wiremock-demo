package com.techragesh.restclientdemo.service;



import com.techragesh.restclientdemo.model.Student;

import java.util.List;

public interface RemoteStudentServiceClient {

    List<Student> getAllStudents();
}
