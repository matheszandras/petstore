package org.petstore.pet;

import io.restassured.http.ContentType;
import org.petstore.Setup;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePetTest extends Setup {

    @Test
    public static void updatePet() {
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
                .put(baseURI + petUrl)
                .then()
                .statusCode(200)
                .body("id", equalTo(18))
                .log().body();
    }
}
