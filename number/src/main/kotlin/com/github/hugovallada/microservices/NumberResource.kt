package com.github.hugovallada.microservices

import org.jboss.logging.Logger
import java.time.Instant
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import kotlin.random.Random

@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
class NumberResource(private val logger: Logger) {

    @GET
    fun generateIsbnNumbers() : IsbnNumbers{
        val isbnNumber = IsbnNumbers(
            "13-" + Random.nextInt(100_000_000),
            "10-" + Random.nextInt(100_000),
            Instant.now()
        )

        logger.info("Numbers generated: $isbnNumber")

        return isbnNumber
    }
}