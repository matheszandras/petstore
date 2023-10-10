package org.petstore.user;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserTest {

    @Test(priority = 4)
    public static void getUser() {
        String user = "https://petstore.swagger.io/v2/user/";
        String userName = "LightningJoe";
        given().get(user + userName).then().statusCode(200).log().body();
    }
}
