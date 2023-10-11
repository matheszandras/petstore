package org.petstore.user;

import io.restassured.http.ContentType;
import org.petstore.Setup;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class AddListOfUsersTest extends Setup {

    @Test
    public static void addListOfUsers() {
        String userArray = "createWithArray/";
        String body = """
                [
                    {
                        "id": 3,
                        "username": "string",
                        "firstName": "string",
                        "lastName": "string",
                        "email": "string",
                        "password": "string",
                        "phone": "string",
                        "userStatus": 0
                    },
                    {
                        "id": 4,
                        "username": "string",
                        "firstName": "string",
                        "lastName": "string",
                        "email": "string",
                        "password": "string",
                        "phone": "string",
                        "userStatus": 0
                    }
                ]""";
        given().contentType(ContentType.JSON).body(body)
                .post(baseURI + userArray)
                .then().statusCode(200)
                .log().body();
    }
}
