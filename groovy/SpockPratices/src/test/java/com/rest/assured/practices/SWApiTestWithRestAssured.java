package com.rest.assured.practices;

import io.restassured.RestAssured;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class SWApiTestWithRestAssured  {

        @Test
        public void whenRequestingAResourceThenLinksToResourcesMustBeReturned() {

            String body = RestAssured
                    .given()
                    .baseUri("http://swapi.co/api")
                    .and()
                    .queryParam("format", "json")
                    .when()
                    .get("/")
                    .then()
                    .log().all()
                    .and().assertThat().statusCode(is(equalTo(200)))
                    .and()
                    .body("films", response -> notNullValue())
                    .body("vehicles", response -> notNullValue())
                    .body("people", response -> notNullValue())
                    .body("starships", response -> notNullValue())
                    .body("species", response -> notNullValue())
                    .body("planets", response -> notNullValue())
                    .and().extract().body().asString();
        }



    @Test
    public void whenRequestingAResourceThenLinksToResources() {

        BaseApiResponse baseApiResponse = RestAssured
                .given()
                .baseUri("http://swapi.co/api")
                .and()
                .queryParam("format", "json")
                .log().all()
                .when()
                .get("/")
                .then()
                .statusCode(is(equalTo(200)))
                .and()
                .body("films", response -> notNullValue())
                .body("vehicles", response -> notNullValue())
                .body("people", response -> notNullValue())
                .body("starships", response -> notNullValue())
                .body("species", response -> notNullValue())
                .body("planets", response -> notNullValue())
                .and().extract().body().as(BaseApiResponse.class);

        RestAssured
                .given()
                .queryParam("format", "json")
                .log().all()
                .when()
                .post(baseApiResponse.getFilms())
                .then()
                .log().all()
                .and()
                .assertThat()
                .statusCode(is(equalTo(405)));
    }

}
