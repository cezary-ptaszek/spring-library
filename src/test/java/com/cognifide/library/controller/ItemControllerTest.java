package com.cognifide.library.controller;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

class ItemControllerTest {

    @Test
    void hello() {
        get("/item/").then().assertThat().statusCode(200);
    }

    @Test
    void getItemByIsbn() {
        get("/item?isbn=9780226285108").then().assertThat().statusCode(200);
    }

    @Test
    void notGetItemByIsbn() {
        get("/item?isbn=9788392789109").then().assertThat().statusCode(404);
    }

    @Test
    void getItemsByCategory() {
        get("/item?category=Religion").then().assertThat().statusCode(200);
    }
}