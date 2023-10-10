package org.petstore.store;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddOrderTest {

    @Test(priority = 0)
    public static void addOrder() {

        String order = "https://petstore.swagger.io/v2/store/order";
        String body = """
                {
                  "id": 1,
                  "petId": 11,
                  "quantity": 2,
                  "shipDate": "2023-10-05T15:28:10.020Z",
                  "status": "placed",
                  "complete": false
                }""";
        given()
                .contentType(ContentType.JSON).body(body)
                .post(order)
                .then().statusCode(200)
                .body("petId", equalTo(11))
                .body("complete", equalTo(false))
                .log().body();
    }
}
