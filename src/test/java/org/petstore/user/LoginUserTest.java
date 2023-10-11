package org.petstore.user;

import org.petstore.Setup;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LoginUserTest extends Setup {

    @Test
    public static void loginUser() {
        String loginUser = "login?username=LightningJoe&password=password";
        given().get(baseURI + loginUser).then().statusCode(200).log().body();
    }
}
