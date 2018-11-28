package com.example.test2

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux
import reactor.core.publisher.toMono
import java.time.Duration

@Component
class MyHandler (private val myRepository: MyRepository) {
    fun showAll(request: ServerRequest): Mono<ServerResponse> {
        //val interval = Flux.interval(Duration.ofSeconds(1))
        //val strs = myRepository.findAll()
        //return ok().bodyToServerSentEvents(Flux.zip(interval, strs).map { it.t2 })
        System.out.println("Show all")
        return ok().body(myRepository.findAll())
    }

    fun addStr(request: ServerRequest): Mono<ServerResponse> {
        val book = request.bodyToMono<Str>()
        System.out.println("Add str")
        return ok().body(myRepository.saveAll(book))
    }

    fun showStr(request: ServerRequest): Mono<ServerResponse> {
        val title = request.pathVariable("title")
        //val interval = Flux.interval(Duration.ofSeconds(1))
        //val strs = myRepository.findByTitle(title)
        //return ok().bodyToServerSentEvents(Flux.zip(interval, strs).map { it.t2 })
        System.out.println("Find $title")
        return ok().body(myRepository.findByTitle(title))
    }

    fun deleteStr(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id")
        System.out.println("Deleting $id")
        return ok().body(myRepository.deleteById(id))
    }

    fun getFoo(request: ServerRequest): Mono<ServerResponse> {
        val str = Str(title = "title")
        System.out.println("Get foo")
        return ok().body(str.toMono())
    }
}