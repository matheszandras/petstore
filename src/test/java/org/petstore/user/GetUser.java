package org.petstore.user;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    @Test
    public static void getUser(){
        String user = "https://petstore.swagger.io/v2/user/";
        String userName = "LigthningJoe";
        given().get(user + userName).then().statusCode(200).log().body();
    }
}
