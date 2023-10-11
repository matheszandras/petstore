package org.petstore.user;

import io.restassured.http.ContentType;
import org.petstore.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UpdateUserTest extends Setup {

    @Test(priority = 3)
    public static void updateUser() {
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
                .body(body).put(baseURI + username)
                .then()
                .statusCode(200)
                .log().body();
        Assert.assertEquals(get(baseURI + username).getBody().jsonPath().get("firstName"), "Joseph_Lawton", "User's firstname not updated");
    }
}
