package com.example.test2

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

@RunWith(SpringRunner::class)
@SpringBootTest
class Test2ApplicationTests {

	lateinit var client: WebTestClient

	@Autowired
	lateinit var routerFunction: RouterFunction<ServerResponse>

	@Before
	fun setUp() {
		client = WebTestClient.bindToRouterFunction(routerFunction).build()
	}

	@Test
	fun contextLoads() {
		client.get().uri("/customer").exchange().expectStatus().isOk
	}
}
