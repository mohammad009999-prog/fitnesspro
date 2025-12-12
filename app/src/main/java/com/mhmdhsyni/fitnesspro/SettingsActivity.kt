package com.fitnesspro

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.fitnesspro.databinding.ActivitySettingsBinding
import java.util.Locale

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = getString(R.string.settings)

        sharedPrefs = getSharedPreferences("Settings", MODE_PRIVATE)
        val currentLangCode = sharedPrefs.getString("LANG_CODE", "en") ?: "en"
        val isDarkMode = sharedPrefs.getBoolean("DARK_MODE", false)

        // --- 1. Language Setup ---
        setupLanguageSpinner(currentLangCode)

        // --- 2. Dark Mode Setup ---
        binding.switchDarkMode.isChecked = isDarkMode
        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            setDarkMode(isChecked)
        }
    }

    private fun setupLanguageSpinner(currentCode: String) {
        val languages = arrayOf("English", "فارسی (Farsi)")
        val languageCodes = arrayOf("en", "fa")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerLanguage.adapter = adapter

        // Set spinner to current language
        val currentPosition = languageCodes.indexOf(currentCode)
        if (currentPosition != -1) {
            binding.spinnerLanguage.setSelection(currentPosition)
        }

        binding.spinnerLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val newLangCode = languageCodes[position]
                if (newLangCode != currentCode) {
                    setLocale(newLangCode)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    // Function to change the app's language
    private fun setLocale(languageCode: String) {
        // 1. Update shared preferences
        sharedPrefs.edit().putString("LANG_CODE", languageCode).apply()

        // 2. Change configuration
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        // 3. Restart activity for changes to take effect
        recreate()
        // If you want the change to reflect on the MainActivity immediately:
        // val intent = Intent(this, MainActivity::class.java).apply {
        //     addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        // }
        // startActivity(intent)
        // finish()
    }

    private fun setDarkMode(isDark: Boolean) {
        sharedPrefs.edit().putBoolean("DARK_MODE", isDark).apply()
        if (isDark) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        // Applying the theme change immediately
        recreate()
    }
}