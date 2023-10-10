package org.petstore.user;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasValue;

public class AddUserTest {

    @Test (priority = 1)
    private static void addUser() {
        String user = "https://petstore.swagger.io/v2/user";
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
                .post(user).then().statusCode(200).body("message", equalTo("11")).log().body();

    }
}
