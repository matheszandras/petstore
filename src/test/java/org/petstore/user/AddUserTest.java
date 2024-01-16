package org.petstore.user;

import io.restassured.http.ContentType;
import org.petstore.Setup;
import org.petstore.apiutils.JsonMapper;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class AddUserTest extends Setup {

    @Test(priority = 1)
    private static void addUser() {
      UserRequestBody user = new UserRequestBody(11, "LightningJoe", "Joseph", "Collins", "test@email.com", "password", "0123456", 11);

        given()
                .contentType(ContentType.JSON)
                .body(JsonMapper.convertToJson(user)).log().body()
                .post(baseURI + userUrl)
                .then().statusCode(200).body("message", equalTo("11"))
                .log().body();
    }
}
