package com.philips.university.api.controller;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentControllerTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp()
    {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/department";
    }

    @Test
    public void test_createDepartment()
    {
        given()
                .body("{\"name\":\"Computer Science\"}")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("name", Matchers.equalTo("Computer Science"));
    }

    @Test
    public void test_getDepartment()
    {
        //        List outputList = new ArrayList();
//
//        outputList.add(DepartmentOutputDTO.builder().id(3).name("Biological Sciences").build());
//        outputList.add(DepartmentOutputDTO.builder().id(5).name("Technology").build());
//
//        return outputList;
        given()
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
