package org.petstore.user;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddListOfUsers {

    @Test
    public static void addListOfUsers() {
        String user = "https://petstore.swagger.io/v2/user/createWithArray";
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
        ValidatableResponse response = given().contentType(ContentType.JSON).body(body).post(user).then().statusCode(200);
    }
}
