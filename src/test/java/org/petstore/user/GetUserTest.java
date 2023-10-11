package org.petstore.user;

import org.petstore.Setup;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GetUserTest extends Setup {

    @Test(priority = 4)
    public static void getUser() {
        String userName = "LightningJoe";
        given().get(baseURI + userName).then().statusCode(200).log().body();
    }
}
