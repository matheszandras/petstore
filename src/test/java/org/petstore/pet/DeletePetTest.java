package org.petstore.pet;

import io.restassured.RestAssured;
import org.petstore.Setup;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class DeletePetTest extends Setup {

    @Test
    private static void deletePet() {
        String postId = "111/";
        RestAssured.given().delete(baseURI + petUrl + postId).then().statusCode(200).log().body();
    }
}
