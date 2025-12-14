package com.mhmdhsyni.fitnesspro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

// MainActivity MUST inherit from LanguageActivity
class MainActivity : LanguageActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Assumes this layout exists

        // Example click listeners for main navigation cards
        setupCardClickListener(R.id.card_exercises, "Exercises")
        setupCardClickListener(R.id.card_nutrition, "Nutrition")
        setupCardClickListener(R.id.card_settings, "Settings")
        setupCardClickListener(R.id.card_profiles, "Bodybuilders") // Example category

        // Assuming you have a button or card for settings
        findViewById<Button>(R.id.btn_settings)?.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun setupCardClickListener(cardId: Int, categoryName: String) {
        findViewById<CardView>(cardId)?.setOnClickListener {
            // Check if it's the Settings card to launch SettingsActivity
            if (categoryName == "Settings") {
                startActivity(Intent(this, SettingsActivity::class.java))
            } else {
                // Otherwise, launch ListActivity with the category title
                val intent = Intent(this, ListActivity::class.java)
                intent.putExtra(ListActivity.LIST_CATEGORY, categoryName)
                startActivity(intent)
            }
        }
    }
}