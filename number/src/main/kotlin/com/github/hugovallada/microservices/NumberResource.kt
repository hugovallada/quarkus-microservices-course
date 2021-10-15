package com.github.hugovallada.microservices

import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import org.jboss.logging.Logger
import org.jboss.resteasy.annotations.Status
import java.time.Instant
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import kotlin.random.Random

@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Number REST Endpoint")
class NumberResource(private val logger: Logger) {

    @GET
    @Operation(
        summary = "Generate book numbers",
        description = "ISBN 13 And ISBN 10"
    )
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