package com.example.test2

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface MyRepository : ReactiveCrudRepository<Str, String> {
    fun findByTitle(name: String): Mono<Str>
}