package org.petstore.store;

import org.petstore.Setup;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteOrderTest extends Setup {

    @Test (priority = 3)
    public static void deleteOrder() {
      /*  String body = """
                {
                  "id": 1,
                  "petId": 11,
                  "quantity": 2,
                  "shipDate": "2023-10-05T15:28:10.020Z",
                  "status": "placed",
                  "complete": false
                }""";*/
        String deleteOrderID = "1/";
        given().delete(baseURI + storeUrl + deleteOrderID).then().statusCode(200).log().body();
        given().get(baseURI + storeUrl + deleteOrderID).then().statusCode(404).log().body();
    }
}
