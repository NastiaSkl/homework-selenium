package io.react.realworldapp.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginTest {

    @Test
    public void loginTest(){
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                        "  \"user\": {\n" +
                        "    \"email\": \"nasskl@email.com\",\n" +
                        "    \"password\": \"qwerty123\"\n" +
                        "  }\n" +
                        "}")
                .when()
                    .post("https://conduit.productionready.io/api/users/login")
                .then()
                    .statusCode(200)
                    .body("user.username", equalTo("nasskl"))
                .log().all();

    }
}
