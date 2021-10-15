package com.github.hugovallada.microservices

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.Instant
import javax.json.bind.annotation.JsonbProperty
import javax.json.bind.annotation.JsonbTransient

@Schema(description = "Severak ISBN numbers for books")
class IsbnNumbers(
    @get:Schema(required = true)
    @get:JsonbProperty("isbn_13")
    val isbn13: String,
    @get:Schema(required = true)
    @get:JsonbProperty("isbn_10")
    val isbn10: String,
    @JsonbTransient
    val generationDate: Instant
) {

    override fun toString(): String {
        return "IsbnNumbers(isbn13='$isbn13', isbn10='$isbn10', generationDate=$generationDate)"
    }
}
