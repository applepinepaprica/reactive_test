package com.example.test2

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import kotlin.test.assertFailsWith

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureWebTestClient
class Test2ApplicationTests {

	@Autowired
	private lateinit var client: WebTestClient

	@Test
	fun foo() {
		client.get().uri("/foo").exchange()
			.expectStatus().isOk
			.expectBody()
			.jsonPath("$.title").isEqualTo("title")

		assertFailsWith(AssertionError::class) {
			client.get().uri("/foo").exchange()
				.expectStatus().isOk
				.expectBody()
				.jsonPath("$.title").isEqualTo("ghjk")
		}
	}

	@Test
	fun title() {
		client.get().uri("/new").exchange()
			.expectStatus().isOk
			.expectBody()
			.jsonPath("$.*[?(@.title == 'new')]").isNotEmpty

		assertFailsWith(AssertionError::class) {
			client.get().uri("/new").exchange()
				.expectStatus().isOk
				.expectBody()
				.jsonPath("$.*[?(@.title == 'fghjkn')]").isNotEmpty
		}
	}
}
