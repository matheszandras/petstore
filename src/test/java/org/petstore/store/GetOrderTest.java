package org.petstore.store;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetOrderTest {

    @Test (priority = 2)
    public static void getOrder(){
        String order = "https://petstore.swagger.io/v2/store/order/1";
        given().get(order).then().statusCode(200)
                .body("petId", equalTo(11))
                .body("complete",equalTo(false))
                .log().body();
    }
}
