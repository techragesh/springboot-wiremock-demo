package com.techragesh.restclientdemo;


import com.github.tomakehurst.wiremock.junit.WireMockRule;

import com.techragesh.restclientdemo.model.Student;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = RestClientDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles(value = "integration")
public class StudentControllerTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(9998);

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() {
        mockRemoteService();
    }

    @Test
    public void testAllStudents() {
        ResponseEntity<List<Student>> responseEntity = testRestTemplate.exchange("http://localhost:8093/all", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<Student>>(){}
        );
        List<Student> studentList = responseEntity.getBody();
        System.out.println("StudentList--->" + studentList.size());
    }

    private void mockRemoteService() {
        stubFor(get(urlEqualTo("/all-students"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("response.json")
                ));
    }
}
