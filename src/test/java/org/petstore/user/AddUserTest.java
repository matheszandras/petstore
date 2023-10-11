package org.petstore.user;

import io.restassured.http.ContentType;
import org.petstore.Setup;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddUserTest extends Setup {

    @Test (priority = 1)
    private static void addUser(){
        String body = """
                {
                  "id": 11,
                  "username": "LightingJoe",
                  "firstName": "Joseph",
                  "lastName": "Collins",
                  "email": "test@email.com",
                  "password": "password",
                  "phone": "01234543210",
                  "userStatus": 11
                }""";
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(baseURI + userUrl)
                .then().statusCode(200).body("message", equalTo("11"))
                .log().body();

    }
}
