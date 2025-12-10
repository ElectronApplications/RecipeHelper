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
    println(helper.nextUnknownIngredients())
    println(helper.recipes())
//    helper.insertIngredientInfo(IngredientInfo("oatMilk", true))
//    helper.insertIngredientInfo(IngredientInfo("cocoaPowder", true))
//    helper.insertIngredientInfo(IngredientInfo("sugar", true))
    helper.insertIngredientInfo(IngredientInfo("salt", false))
//    helper.insertIngredientInfo(IngredientInfo("vanillaExtract", true))
    println(helper.nextUnknownIngredients())
    println(helper.recipes())
    helper.close()

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