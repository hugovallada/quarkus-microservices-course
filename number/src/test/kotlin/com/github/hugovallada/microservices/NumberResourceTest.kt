package com.github.hugovallada.microservices

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

@QuarkusTest
class NumberResourceTest {

    @Test
    fun `should generate isbn numbers`() {
        given()
            .`when`()
            .get("/api/numbers")
            .then()
            .statusCode(200)
            .body("isbn_13", Matchers.startsWith("13-"))
            .body("isbn_10", Matchers.startsWith("10-"))
    }
}