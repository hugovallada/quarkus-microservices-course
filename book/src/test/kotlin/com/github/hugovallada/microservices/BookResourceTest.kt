package com.github.hugovallada.microservices

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import javax.inject.Inject

@QuarkusTest
class BookResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
            .formParam("title", "Uncovered")
            .formParam("author", "Hugo")
            .formParam("year", 2020)
            .formParam("genre", "IT")
          .`when`().post("/api/books")
          .then()
             .statusCode(201)
    }

}