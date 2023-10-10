package org.petstore.pet;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostPet {
    @Test
    public static void postPet() {
        String pet = "https://petstore.swagger.io/v2/pet";
        String body = """
                {
                	"id": 111,
                	"category": {
                		"id": 15,
                		"name": "cat"
                	},
                	"name": "cat",
                	"photoUrls": [
                	],
                	"tags": [
                		{
                			"id": 0,
                			"name": "string"
                		}
                	],
                	"status": "available"
                }
                """;
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(pet)
                .then()
                .statusCode(200)
                .body("id", equalTo(111))
                .log().body();
    }
}
