package com.fitnesspro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fitnesspro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declare the binding object for ViewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding and set content view
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- Setup Button Listeners ---
        // Exercises goes to the grouping screen
        binding.btnExercises.setOnClickListener {
            startActivity(Intent(this, ExerciseGroupActivity::class.java))
        }

        // These use the generic list router
        binding.btnInjuries.setOnClickListener { openListActivity("injuries") }
        binding.btnSupplements.setOnClickListener { openListActivity("supplements") }
        binding.btnGyms.setOnClickListener { openListActivity("gyms") }
        binding.btnNutrition.setOnClickListener { openListActivity("nutrition") }

        // These go to specific screens
        binding.btnBodybuilders.setOnClickListener {
            startActivity(Intent(this, BodybuildersActivity::class.java))
        }
        binding.btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    /**
     * Helper function to send the data type to the ListActivity router.
     */
    private fun openListActivity(type: String) {
        val intent = Intent(this, ListActivity::class.java)
        intent.putExtra("TYPE", type)
        startActivity(intent)
    }
}