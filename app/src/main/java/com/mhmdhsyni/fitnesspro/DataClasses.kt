package com.mhmdhsyni.fitnesspro

// Base interface for all fitness-related items (used by RecyclerView Adapter)
interface BaseFitnessItem {
    val title: String
    val category: String
    val description: String
    val imageResource: Int
}

// 1. Core data class for Exercises/Categories
data class FitnessItem(
    override val title: String,
    override val category: String,
    override val description: String,
    override val imageResource: Int = R.drawable.ic_exercise_placeholder // Default placeholder
) : BaseFitnessItem

// 2. Data class for Food/Nutrition items (Requires R.drawable.ic_exercise_placeholder)
data class FoodItem(
    override val title: String,
    override val category: String = "Food",
    override val description: String,
    override val imageResource: Int = R.drawable.ic_exercise_placeholder,
    val calories: String,
    val protein: String,
    val fats: String
) : BaseFitnessItem

// 3. Data class for Bodybuilder Profiles (Requires R.drawable.ic_exercise_placeholder)
data class BodybuilderProfile(
    override val title: String,
    override val category: String = "Profiles",
    override val description: String,
    override val imageResource: Int = R.drawable.ic_exercise_placeholder,
    val careerHighlights: String,
    val trainingPhilosophy: String,
    val dietStyle: String
) : BaseFitnessItem