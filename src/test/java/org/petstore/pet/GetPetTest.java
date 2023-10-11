package org.petstore.pet;

import io.restassured.RestAssured;
import org.petstore.Setup;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;

public class GetPetTest extends Setup {


    @Test(priority = 2)
    public static void getPet() {
        String example = "0/";
        RestAssured.given().get(baseURI + petUrl + example).then().statusCode(404).body("message",equalTo("Pet not found"))
                .log().body();
    }
}
