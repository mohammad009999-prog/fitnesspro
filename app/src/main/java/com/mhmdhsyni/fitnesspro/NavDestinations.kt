package com.mhmdhsyni.fitnesspro // CRITICAL: This package name must be correct

import androidx.annotation.DrawableRes
import com.mhmdhsyni.fitnesspro.R // Explicitly import the R file

// Class to define a navigation item
data class NavItem(
    val title: String,
    @DrawableRes val icon: Int,
    val route: String
)

object NavDestinations {
    // Using ic_launcher_foreground as a guaranteed temporary resource
    val Home = NavItem("Home", R.drawable.ic_launcher_foreground, "home_route")
    val Exercises = NavItem("Exercises", R.drawable.ic_launcher_foreground, "exercises_route")
    val Injuries = NavItem("Injuries", R.drawable.ic_launcher_foreground, "injuries_route")
    val Supplements = NavItem("Supplements", R.drawable.ic_launcher_foreground, "supplements_route")
    val Nutrition = NavItem("Nutrition", R.drawable.ic_launcher_foreground, "nutrition_route")
    val Bodybuilders = NavItem("Bodybuilders", R.drawable.ic_launcher_foreground, "bodybuilders_route")

    val allMainItems = listOf(Home, Exercises, Injuries, Supplements, Nutrition, Bodybuilders)
}