package com.fitnesspro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fitnesspro.databinding.ActivityExerciseDetailBinding
import org.json.JSONObject

class ExerciseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Binds the new layout
        binding = ActivityExerciseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val exerciseJsonString = intent.getStringExtra("EXERCISE_JSON")
        if (exerciseJsonString.isNullOrEmpty()) {
            finish()
            return
        }

        val exercise = JSONObject(exerciseJsonString)
        title = exercise.optString("name") // Set the action bar title (e.g., "Barbell Bench Press")

        // 1. Muscles Worked
        binding.tvMusclesLabel.text = getString(R.string.muscles_worked)
        binding.tvMuscles.text = exercise.optString("muscles")

        // 2. Tutorial
        binding.tvTutorialLabel.text = getString(R.string.how_to_tutorial)
        binding.tvTutorial.text = exercise.optString("tutorial")

        // 3. Mistakes to Avoid
        binding.tvMistakesLabel.text = getString(R.string.mistakes_to_avoid)
        binding.tvMistakes.text = exercise.optString("mistakes")

        // 4. Notes
        binding.tvNotesLabel.text = getString(R.string.notes)
        binding.tvNotes.text = exercise.optString("notes")
    }
}