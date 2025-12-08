package org.example

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.respond
import io.ktor.server.routing.*

fun main() {
    val helper = RecipeHelper()
    println(helper.nextIngredientsQuestion())
//    do {
//        val questions = helper.nextIngredientsQuestion()
//        println(questions)
//    } while (questions.isNotEmpty())

    println("Starting server")
    embeddedServer(Netty, 8080) {
        install(ContentNegotiation) {
            json()
        }
        routing {
            get("/ingredients") {
                call.respond(ingredients)
            }
        }
    }.start(wait = true)
}