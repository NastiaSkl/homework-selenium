package io.react.realworldapp.api;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;


public class AddArticleTest {


    @Test
    public void newArticleTest(){
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6OTc4NzUsInVzZXJuYW1lIjoibmFzc2tsIiwiZXhwIjoxNTk1MTY5MTQzfQ.zmGZItf1Ey6TfFtquWIe4ym0eKLIEAXFWy79BfkDiOw")
                    .body("{\n" +
                        "  \"article\": {\n" +
                        "    \"title\": \"Nastia\",\n" +
                        "    \"description\": \"Nastia_article1\",\n" +
                        "    \"body\": \"Nastia_article_body1\",\n" +
                        "    \"tagList\": [\n" +
                        "      \"tag11\",\n" +
                        "      \"tag21\"\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}")
                .when()
                    .post("https://conduit.productionready.io/api/articles")
                .then()
                    .statusCode(200)
                .log().all();


    }
}
