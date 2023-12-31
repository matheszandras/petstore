package org.petstore.pet;

import io.restassured.http.ContentType;
import org.petstore.Setup;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostPetTest extends Setup {
    @Test (priority = 1)
    public static void postPet() {
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
                .post(baseURI + petUrl)
                .then()
                .statusCode(200)
                .body("id", equalTo(111))
                .log().body();
    }
}
