package org.petstore.user;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginUserTest {

    @Test
    public static void loginUser(){
        String loginUser = "https://petstore.swagger.io/v2/user/login?username=LightningJoe&password=password";
        given().get(loginUser).then().statusCode(200).log().body();
    }
}
