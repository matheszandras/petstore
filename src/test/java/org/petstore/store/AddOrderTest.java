package org.petstore.store;

import io.restassured.http.ContentType;
import org.petstore.Setup;
import org.petstore.apiutils.JsonMapper;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddOrderTest extends Setup {

    @Test(priority = 0)
    public static void addOrder() {
        String body = """
                {
                  "id": 1,
                  "petId": 11,
                  "quantity": 2,
                  "shipDate": "2023-10-05T15:28:10.020Z",
                  "status": "placed",
                  "complete": false
                }""";

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDate = dateTime.format(myFormatObj);
        System.out.println(formattedDate);


        StoreRequestBody store = new StoreRequestBody(1, 11, 2, formattedDate,"placed",false );

        given()
                .contentType(ContentType.JSON).body(JsonMapper.convertToJson(store))
                .post(baseURI + storeUrl)
                .then().statusCode(200)
                .body("petId", equalTo(11))
                .body("complete", equalTo(false))
                .log().body();
    }
}
