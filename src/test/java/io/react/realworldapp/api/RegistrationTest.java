package io.react.realworldapp.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import model.ApiUser;
import model.User;
import model.UserData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;


public class RegistrationTest {


//        @BeforeClass
//        public void setUp(){
//        RestAssured.baseURI = "https://conduit.productionready.io";
//        RestAssured.basePath = "/api";
//        RestAssured.requestSpecification =
//                new RequestSpecBuilder()
//                        .setAccept(ContentType.JSON)
//                        .setContentType(ContentType.JSON)
//                        .log(LogDetail.ALL)
//                        .build();
//    }



        @Test
        public void registrationUserTest() {
            RestAssured
                .given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "  \"user\": {\n" +
                            "    \"username\": \"nasskl\",\n" +
                            "    \"email\": \"nasskl@email.com\",\n" +
                            "    \"password\": \"qwerty123\"\n" +
                            "  }\n" +
                            "}")
                    .when()
                        .post("https://conduit.productionready.io/api/users")
                    .then()
                        .statusCode(200)
                        .body("user.email", equalTo("nasskl@email.com"))
                        .body("user.username", equalTo("nasskl"))
                        //.body("user.token", not(emptyOrNullString())
                    .log().all();



    }
}
