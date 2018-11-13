package com.techragesh.restclientdemo.service;


import com.techragesh.restclientdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RemoteStudentServiceClientImpl implements RemoteStudentServiceClient{

    @Value(value = "${remote.url}")
    private String remoteServiceURL;

    private final RestTemplate restTemplate;

    @Autowired
    public RemoteStudentServiceClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Student> getAllStudents() {
        ResponseEntity<List<Student>> responseEntity = restTemplate.exchange(remoteServiceURL, HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Student>>(){});
        return responseEntity.getBody();
    }
}
