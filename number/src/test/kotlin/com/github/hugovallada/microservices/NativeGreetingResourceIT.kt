package com.github.hugovallada.microservices

import io.quarkus.test.junit.NativeImageTest

@NativeImageTest
class NativeGreetingResourceIT : GreetingResourceTest()