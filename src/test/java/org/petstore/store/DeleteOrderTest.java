package org.petstore.store;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteOrderTest {

    @Test (priority = 3)
    public static void deleteOrder() {
        //String order = "https://petstore.swagger.io/v2/store/order";
      /*  String body = """
                {
                  "id": 1,
                  "petId": 11,
                  "quantity": 2,
                  "shipDate": "2023-10-05T15:28:10.020Z",
                  "status": "placed",
                  "complete": false
                }""";*/
        String deleteOrder = "https://petstore.swagger.io/v2/store/order/1";
        given().delete(deleteOrder).then().statusCode(200).log().body();
        String getOrder = "https://petstore.swagger.io/v2/store/order/1";
        given().get(getOrder).then().statusCode(404).log().body();
    }
}
