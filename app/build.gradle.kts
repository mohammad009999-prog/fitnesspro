// Module-level app/build.gradle.kts

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.mhmdhsyni.fitnesspro"
    compileSdk = 34

    // Enable both binding features
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    defaultConfig {
        applicationId = "com.mhmdhsyni.fitnesspro"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Core Dependencies (compatible with SDK 34 / AGP 8.6.1)
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.activity:activity-ktx:1.8.0")
    implementation(libs.androidx.constraintlayout)

    // FIX: Using correct modern ANDROIDX Data Binding dependencies with a stable version
    implementation("androidx.databinding:databinding-runtime:4.1.0")
    implementation("androidx.databinding:databinding-adapters:4.1.0")
    implementation("androidx.databinding:databinding-ktx:4.1.0")

    // Testing libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}