package org.petstore.pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DeletePetTest {

    @Test
    private static void deletePet (){
        String postId ="111";
        String pet = "https://petstore.swagger.io/v2/pet/" + postId;
        RestAssured.given().delete(pet).then().statusCode(200).log().body();

    }
}