package org.petstore.pet;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutPet {

    @Test
    public static void putPet() {
        String pet = "https://petstore.swagger.io/v2/pet";
        String body = """
                {
                	"id": 18,
                	"category": {
                		"id": 1,
                		"name": "cat"
                	},
                	"name": "cat",
                	"photoUrls": [
                		"teve"
                	],
                	"tags": [
                		{
                			"id": 0,
                			"name": ""
                		},
                		{
                			"id": 1,
                			"name": "pet"
                		}
                	],
                	"status": "pending"
                }""";
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .put(pet)
                .then()
                .statusCode(200)
                .body("id", equalTo(18))
                .log().body();
    }
}
