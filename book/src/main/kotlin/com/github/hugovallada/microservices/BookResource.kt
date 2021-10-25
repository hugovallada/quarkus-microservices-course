package com.github.hugovallada.microservices

import org.eclipse.microprofile.faulttolerance.Fallback
import org.eclipse.microprofile.faulttolerance.Retry
import org.eclipse.microprofile.faulttolerance.Timeout
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.jboss.logging.Logger
import java.time.Instant
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api/books")
@Produces(value = [MediaType.APPLICATION_JSON])
class BookResource(@Inject val logger: Logger, @RestClient val proxy: BookProxy) { // @RestClient é obrigatório

    @POST
    @Consumes(value = [MediaType.APPLICATION_FORM_URLENCODED])
    @APIResponses(
        value = [
            APIResponse(
                description = "Book Response",
                responseCode = "201",
                content = [Content(schema = Schema(implementation = Book::class))]
            ),
            APIResponse(description = "Not Found", responseCode = "404")
        ]
    )
    @Fallback(fallbackMethod = "fallbackOnCreatingABook")
    @Retry(
        maxRetries = 3,
        delay = 3000
    )
    @Timeout(value = 1000)
    fun createABook(
        @FormParam("title") title: String,
        @FormParam("author") author: String,
        @FormParam("year") yearOfPublication: Int,
        @FormParam("genre") genre: String
    ): Response {
        val isbn = proxy.generateIsbnNumbers()
        logger.info(isbn)
        val book = Book(isbn.isbn13, title, author, yearOfPublication, genre, Instant.now())
        return Response.status(201).entity(book).build()
    }


    private fun fallbackOnCreatingABook(title: String, author: String, yearOfPublication: Int, genre: String) : Response {
        return Response.status(206).entity("Will be saved later").build()
    }
}