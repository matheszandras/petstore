package org.petstore;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class Setup {

    public static String petUrl = "pet/";
    public static String storeUrl = "store/order/";
    public static String userUrl = "user/";

    @BeforeSuite
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
    }


}
