package com.mhmdhsyni.fitnesspro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

// SettingsActivity MUST inherit from LanguageActivity
class SettingsActivity : LanguageActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings) // Assumes this layout exists

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Example buttons for language switching (R.id.btn_lang_en and R.id.btn_lang_ar must exist in XML)
        findViewById<Button>(R.id.btn_lang_en)?.setOnClickListener {
            setNewLocale("en")
        }

        findViewById<Button>(R.id.btn_lang_ar)?.setOnClickListener {
            setNewLocale("ar")
        }
    }

    private fun setNewLocale(languageCode: String) {
        // Save the new language preference
        LanguageUtils.saveLanguage(this, languageCode)
        Toast.makeText(this, "Language set to $languageCode. Restarting app...", Toast.LENGTH_SHORT).show()

        // Restart the main activity to apply changes to the whole app
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
        finish()
    }

    // Enables the Up button functionality
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}