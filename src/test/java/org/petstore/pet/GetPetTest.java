package org.petstore.pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetPetTest {


    @Test(priority = 2)
    public static void getPet() {
        String pet = "https://petstore.swagger.io/v2/pet/";
        RestAssured.given().get(pet + "0").then().statusCode(404).body("message",equalTo("Pet not found"))
                .log().body();
    }
}
