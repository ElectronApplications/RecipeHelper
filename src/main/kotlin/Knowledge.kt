package org.example

import kotlinx.serialization.Serializable

@Serializable
enum class IngredientAmountType {
    Millilitres,
    Grams,
    Pieces
}

@Serializable
data class IngredientDescription(
    val id: String,
    val name: String,
    val amountType: IngredientAmountType,
)

@Serializable
data class Ingredient(
    val ingredient: String,
    val amount: Double
)

@Serializable
data class Recipe(
    val name: String,
    val recipeSteps: List<String>,
    val ingredients: List<Ingredient>
)

val ingredients = listOf(
    IngredientDescription(id = "flour", name = "Flour", amountType = IngredientAmountType.Grams),
    IngredientDescription(id = "oatMilk", name = "Oat milk", amountType = IngredientAmountType.Millilitres),
    IngredientDescription(id = "sugar", name = "Sugar", amountType = IngredientAmountType.Grams),
    IngredientDescription(id = "salt", name = "Salt", amountType = IngredientAmountType.Grams),
    IngredientDescription(id = "bakingPowder", name = "Baking Powder", amountType = IngredientAmountType.Grams),
    IngredientDescription(id = "vegetableOil", name = "Vegetable Oil", amountType = IngredientAmountType.Millilitres),
    IngredientDescription(id = "banana", name = "Banana", amountType = IngredientAmountType.Pieces),
    IngredientDescription(id = "cocoaPowder", name = "Cocoa Powder", amountType = IngredientAmountType.Grams),
    IngredientDescription(id = "chocolateChips", name = "Chocolate Chips", amountType = IngredientAmountType.Grams),
    IngredientDescription(
        id = "vanillaExtract",
        name = "Vanilla Extract",
        amountType = IngredientAmountType.Millilitres
    ),
    IngredientDescription(id = "mapleSyrup", name = "Maple Syrup", amountType = IngredientAmountType.Millilitres),
    IngredientDescription(id = "rolledOats", name = "Rolled Oats", amountType = IngredientAmountType.Grams),
    IngredientDescription(id = "water", name = "Water", amountType = IngredientAmountType.Millilitres)
)

val recipes = listOf(
    Recipe(
        name = "Banana Pancakes",
        recipeSteps = listOf(
            "Mash the banana in a bowl.",
            "Add flour, sugar, baking powder, and salt. Mix well.",
            "Pour in oat milk and vanilla extract, whisk until smooth.",
            "Heat oil in a pan and cook spoonfuls of batter until golden brown on both sides."
        ),
        ingredients = listOf(
            Ingredient("flour", 120.0),
            Ingredient("oatMilk", 200.0),
            Ingredient("banana", 1.0),
            Ingredient("sugar", 15.0),
            Ingredient("bakingPowder", 5.0),
            Ingredient("salt", 2.0),
            Ingredient("vegetableOil", 10.0),
            Ingredient("vanillaExtract", 5.0)
        )
    ),

    Recipe(
        name = "Chocolate Chip Oatmeal Cookies",
        recipeSteps = listOf(
            "Preheat oven to 180°C (350°F).",
            "Mix wet ingredients: mashed banana, maple syrup, and vegetable oil.",
            "Mix dry ingredients: rolled oats, flour, baking powder, and salt.",
            "Combine wet and dry mixtures. Fold in chocolate chips.",
            "Spoon onto a baking sheet and bake for 12-15 minutes."
        ),
        ingredients = listOf(
            Ingredient("banana", 2.0),
            Ingredient("mapleSyrup", 80.0),
            Ingredient("vegetableOil", 60.0),
            Ingredient("rolledOats", 150.0),
            Ingredient("flour", 50.0),
            Ingredient("bakingPowder", 3.0),
            Ingredient("salt", 1.0),
            Ingredient("chocolateChips", 100.0)
        )
    ),

    Recipe(
        name = "Hot Chocolate",
        recipeSteps = listOf(
            "Heat oat milk in a saucepan over medium heat, do not boil.",
            "Whisk in cocoa powder, sugar, and a pinch of salt until dissolved and smooth.",
            "Remove from heat and stir in vanilla extract.",
            "Pour into mugs and enjoy."
        ),
        ingredients = listOf(
            Ingredient("oatMilk", 500.0),
            Ingredient("cocoaPowder", 30.0),
            Ingredient("sugar", 20.0),
            Ingredient("salt", 0.5),
            Ingredient("vanillaExtract", 2.0)
        )
    )
)