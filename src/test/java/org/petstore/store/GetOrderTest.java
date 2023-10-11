package org.petstore.store;

import org.petstore.Setup;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetOrderTest extends Setup {

    @Test (priority = 2)
    public static void getOrder(){
        String orderId = "1/";
        given().get(baseURI + storeUrl + orderId).then().statusCode(200)
                .body("petId", equalTo(11))
                .body("complete",equalTo(false))
                .log().body();
    }
}
