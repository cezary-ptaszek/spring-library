package com.cognifide.library.controller;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

class AuthorControllerTest {

    @Test
    void getAuthorsRating(){
        get("/author/rating").then().assertThat().statusCode(200);
    }

    @Test
    void getAuthorByName() {
        when()
                .get("/author/rating?name=Jain Pravin").
        then()
                .statusCode(200)
                .body("name", equalTo("Jain Pravin"),
                        "rating", equalTo(5.0f),
                        "allCounter", equalTo(9),
                        "currCounter",equalTo(0));
    }

    @Test
    void notGetAuthorByName() {
        get("/author/rating?name=Adam Mickiewicz").then().assertThat().statusCode(404);
    }

}