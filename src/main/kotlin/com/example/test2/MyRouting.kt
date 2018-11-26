package com.example.test2

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class MyRouting {

    @Bean
    fun myRouter(handler: MyHandler) = router {
        ("/" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("/", handler::showAll)
            GET("/foo", handler::getFoo)
            GET("/{title}", handler::showStr)
            POST("/", handler::addStr)
            DELETE("/{id}", handler::deleteStr)
        }
    }
}