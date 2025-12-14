package com.mhmdhsyni.fitnesspro

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

/**
 * Base Activity to handle language/locale switching dynamically.
 * All other Activities should inherit from this class.
 */
open class LanguageActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        // Retrieve the saved language code
        val lang = LanguageUtils.getSavedLanguage(newBase)

        // Use the utility function to create a context with the new locale
        val context = LanguageUtils.setLocale(newBase, lang)

        // Attach the new context
        super.attachBaseContext(context)
    }
}