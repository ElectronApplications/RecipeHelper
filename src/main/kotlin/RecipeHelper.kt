package org.example

import org.kie.api.KieServices
import org.kie.api.builder.KieBuilder
import org.kie.api.builder.KieFileSystem
import org.kie.api.builder.KieModule
import org.kie.api.runtime.KieContainer
import org.kie.api.runtime.KieSession
import org.kie.internal.io.ResourceFactory

data class UnknownIngredient(
    val ingredient: String,
    val weight: Double
)

class RecipeHelper : AutoCloseable {
    companion object {
        val kieServices: KieServices = KieServices.Factory.get()
        val kieFileSystem: KieFileSystem =
            kieServices.newKieFileSystem().write(ResourceFactory.newClassPathResource("rules/recipes.drl"))
        val kieBuilder: KieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll()
        val kieModule: KieModule = kieBuilder.kieModule
        val kieContainer: KieContainer = kieServices.newKieContainer(kieModule.releaseId)
    }

    val kieSession: KieSession = kieContainer.newKieSession()
    override fun close() {
        kieSession.dispose()
    }

    init {
        ingredients.forEach { kieSession.insert(it) }
        recipes.forEach { kieSession.insert(it) }
        kieSession.fireAllRules()
    }

    fun nextIngredientsQuestion(): List<UnknownIngredient> {
        return kieSession.getQueryResults("Unknown Ingredients").map { it[$$"$ingredient"] as UnknownIngredient }.sortedByDescending { it.weight }
    }

//    fun recipes(): List<Recipe> {
//        return kieSession.getQueryResults("Possible Recipes").map { it[$$"$recipe"] as Recipe }
//    }
}