package com.github.hugovallada.microservices

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Contact
import org.eclipse.microprofile.openapi.annotations.info.Info
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

@ApplicationPath("/")
@OpenAPIDefinition(
    info = Info(
        title = "Number Microservices",
        description = "This microservice generates a book number",
        version = "1.0",
        contact = Contact(name = "@hugo_vallada", url = "http://twitter.com/hugo_vallada")
    ),
    externalDocs = ExternalDocumentation(url = "http://github.com/hugovallada"),
    tags = [
        Tag(name = "api", description = "Public API that can generate books numbers"),
        Tag(name = "numbers", description = "Anybody can access")
    ]
)
class NumberMicroservices : Application() {
}