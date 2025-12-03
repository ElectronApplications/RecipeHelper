package org.example

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.respond
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
enum class IngredientAmountType {
    Millilitres,
    Grams,
    Pieces
}

@Serializable
data class IngredientDescription(
    val name: String,
    val amountType: IngredientAmountType,
)

@Serializable
data class Ingredient(
    val ingredient: IngredientDescription,
    val amount: Double
)

@Serializable
data class Recipe(
    val name: String,
    val recipeSteps: List<String>,
    val ingredients: List<Ingredient>
)

val flour = IngredientDescription(name = "Flour", amountType = IngredientAmountType.Grams)
val oatMilk = IngredientDescription(name = "Oat milk", amountType = IngredientAmountType.Millilitres)

fun main() {
    println("Starting server")
    embeddedServer(Netty, 8080) {
        install(ContentNegotiation) {
            json()
        }
        routing {
            get("/ingredients") {
                call.respond(listOf(flour, oatMilk))
            }
        }
    }.start(wait = true)
}