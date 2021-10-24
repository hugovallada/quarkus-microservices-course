package com.github.hugovallada.microservices

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.Instant
import javax.json.bind.annotation.JsonbCreator
import javax.json.bind.annotation.JsonbDateFormat
import javax.json.bind.annotation.JsonbProperty

class Book @JsonbCreator constructor(
    @get:JsonbProperty("isbn_13")
    val isbn13: String,
    val title: String,
    val author: String,
    @get:JsonbProperty("year_of_publication")
    val yearOfPublication: Int,
    val genre: String,
    @get:JsonbProperty("creation_date")
    @get:JsonbDateFormat("YYYY-mm-dd")
    @get:Schema(implementation = String::class, format = "date")
    val creationDate: Instant
) {

    override fun toString(): String {
        return "Book(isbn13='$isbn13', title='$title', author='$author', yearOfPublication=$yearOfPublication, genre='$genre', creationDate=$creationDate)"
    }
}