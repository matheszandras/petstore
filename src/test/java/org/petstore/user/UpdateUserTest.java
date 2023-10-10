package org.petstore.user;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class UpdateUserTest {

    @Test (priority = 3)
    public static void updateUser() {
        String user = "https://petstore.swagger.io/v2/user/";
        String username = "LightningJoe";
        String body = """
                {
                  "id": 11,
                  "username": "LightningJoe",
                  "firstName": "Joseph_Lawton",
                  "lastName": "Collins",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";
        given()
                .contentType(ContentType.JSON)
                .body(body).put(user + username)
                .then()
                .statusCode(200)
                .log().body();

        String getUser = "https://petstore.swagger.io/v2/user/LightningJoe";
        Assert.assertEquals(get(getUser).getBody().jsonPath().get("firstName"),"Joseph_Lawton","User's firstname not updated");
    }
}
