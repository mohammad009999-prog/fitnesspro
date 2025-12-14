// In ExerciseDetailActivity.kt
package com.mhmdhsyni.fitnesspro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mhmdhsyni.fitnesspro.databinding.ActivityExerciseDetailBinding

class ExerciseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use View Binding pattern
        binding = ActivityExerciseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ... Your existing logic for loading exercise data goes here ...
    }
}