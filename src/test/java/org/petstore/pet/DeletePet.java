package org.petstore.pet;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class DeletePet {

    @Test
    private static void deletePet (){
        String postId ="111";
        String pet = "https://petstore.swagger.io/v2/pet/" + postId;
        ValidatableResponse response = RestAssured.given().delete(pet).then().statusCode(200);
        response.log().body();
    }
}
