package com.mhmdhsyni.fitnesspro

import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.mhmdhsyni.fitnesspro.FitnessData // <--- Explicit import to resolve getDetailByTitle
import java.util.Locale

// Assumes DataClasses.kt contains BaseFitnessItem, FitnessItem, FoodItem, and BodybuilderProfile
class DetailActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    companion object {
        const val DETAIL_TITLE = "detail_title"
        private const val TAG = "DetailActivity"
    }

    private lateinit var tts: TextToSpeech
    private lateinit var btnTtsPlay: Button
    private lateinit var detailDescription: TextView
    private var isTtsInitialized = false
    private var currentTextToSpeak: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailTitle = intent.getStringExtra(DETAIL_TITLE) ?: "Detail"
        title = detailTitle // Sets the activity title

        val data = FitnessData.getDetailByTitle(detailTitle)

        // Initialize TTS
        tts = TextToSpeech(this, this)
        btnTtsPlay = findViewById(R.id.btn_tts_play)
        btnTtsPlay.setOnClickListener { toggleTts() }

        // Core UI elements
        val layoutDetailContent: LinearLayout = findViewById(R.id.layout_detail_content)
        val detailImage: ImageView = findViewById(R.id.detail_image)
        detailDescription = findViewById(R.id.detail_description)

        // 1. Common Setup: Description and Image
        if (data != null) {
            val descriptionText = when (data) {
                is FitnessItem -> data.description
                is FoodItem -> data.description
                is BodybuilderProfile -> data.description
                else -> ""
            }
            detailDescription.text = descriptionText
            currentTextToSpeak = descriptionText.replace("**", "") // Prepare text for TTS

            // Show media if available
            val imageResId = when (data) {
                is FitnessItem -> data.imageResource
                is FoodItem -> data.imageResource
                is BodybuilderProfile -> data.imageResource
                else -> 0
            }
            if (imageResId != 0) {
                detailImage.setImageResource(imageResId)
                detailImage.visibility = View.VISIBLE
            }
        }

        // 2. Data Type Specific Cards (Professional Look)
        when (data) {
            is FitnessItem -> {
                // Card for Exercise Details (e.g., Focus, Category)
                addCard(layoutDetailContent, "Category & Focus",
                    "Category: ${data.category}\nFocus: Pectorals, Deltoids, etc.")

                // TTS button visible only for FitnessItems as they have long descriptions
                btnTtsPlay.visibility = View.VISIBLE
            }
            is FoodItem -> {
                // Card for Nutrition Details
                addCard(layoutDetailContent, "Nutritional Facts (per 100g)",
                    "Calories: ${data.calories}\nProtein: ${data.protein}\nCarbs/Fats: (Details needed)")
            }
            is BodybuilderProfile -> {
                // Card for Training/Diet Philosophy
                addCard(layoutDetailContent, "Career & Philosophy",
                    "Training: ${data.trainingPhilosophy}\nDiet: ${data.dietStyle}")
            }
            else -> {
                detailDescription.text = "Error: Data not found for $detailTitle. Check data setup."
            }
        }
    }

    // Helper to create a clean CardView dynamically
    private fun addCard(parent: LinearLayout, title: String, content: String) {
        val card = LayoutInflater.from(this as Context).inflate(R.layout.card_detail_info, parent, false) as CardView
        card.findViewById<TextView>(R.id.card_title).text = title
        card.findViewById<TextView>(R.id.card_content).text = content
        parent.addView(card)
    }

    // =========================================================================
    // TTS IMPLEMENTATION
    // =========================================================================
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // Set language based on current app locale
            // NOTE: This assumes LanguageUtils.kt and R.string.select_language are correctly defined.
            val langCode = LanguageUtils.getSavedLanguage(this)
            val result = tts.setLanguage(Locale(langCode))

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e(TAG, "TTS Language not supported: $langCode")
                Toast.makeText(this, getString(R.string.select_language), Toast.LENGTH_SHORT).show()
                btnTtsPlay.isEnabled = false
            } else {
                isTtsInitialized = true
                btnTtsPlay.isEnabled = true
                btnTtsPlay.text = getString(R.string.tts_play)
            }
        } else {
            Log.e(TAG, "TTS Initialization Failed!")
            btnTtsPlay.isEnabled = false
        }
    }

    private fun toggleTts() {
        if (!isTtsInitialized) return

        if (tts.isSpeaking) {
            tts.stop()
            btnTtsPlay.text = getString(R.string.tts_play)
        } else {
            tts.speak(currentTextToSpeak, TextToSpeech.QUEUE_FLUSH, null, "DETAIL_TTS")
            btnTtsPlay.text = getString(R.string.tts_stop)
        }
    }

    override fun onPause() {
        if (tts.isSpeaking) {
            tts.stop()
        }
        super.onPause()
    }

    override fun onDestroy() {
        // Shutdown TTS when activity is destroyed
        tts.stop()
        tts.shutdown()
        super.onDestroy()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
} // <-- FINAL CLOSING BRACE for the DetailActivity class.