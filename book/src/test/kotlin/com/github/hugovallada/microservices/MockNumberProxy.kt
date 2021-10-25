package com.github.hugovallada.microservices

import io.quarkus.test.Mock
import org.eclipse.microprofile.rest.client.inject.RestClient

@Mock
@RestClient
class MockNumberProxy : BookProxy {
    override fun generateIsbnNumbers(): IsbnThirteen {
        return IsbnThirteen("13-0002982")
    }
}