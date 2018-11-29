package com.example.test2.str

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface MyRepository : ReactiveCrudRepository<Str, String> {
    fun findByTitle(name: String): Flux<Str>
}