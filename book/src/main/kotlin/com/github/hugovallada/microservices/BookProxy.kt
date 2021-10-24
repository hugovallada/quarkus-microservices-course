package com.github.hugovallada.microservices

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.json.bind.annotation.JsonbCreator
import javax.json.bind.annotation.JsonbProperty
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/api/numbers")
@Produces(value = [MediaType.APPLICATION_JSON])
@RegisterRestClient(configKey = "number.proxy")
interface BookProxy {

    @GET
    fun generateIsbnNumbers(): IsbnThirteen
}


data class IsbnThirteen @JsonbCreator constructor(
    @param:JsonbProperty("isbn_13")
    val isbn13: String
)