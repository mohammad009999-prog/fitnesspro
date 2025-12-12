// Root Project-level build.gradle.kts (CLEANED)

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

// REMOVED THE allprojects { repositories { ... } } BLOCK HERE
// It is now moved to settings.gradle.kts