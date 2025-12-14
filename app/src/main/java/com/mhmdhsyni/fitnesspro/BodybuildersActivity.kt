package com.mhmdhsyni.fitnesspro

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
// Assuming you have a binding class for this activity, which is based on activity_bodybuilders.xml
// Even if the XML is empty, ViewBinding needs this class definition to exist.
import com.mhmdhsyni.fitnesspro.databinding.ActivityBodybuildersBinding

class BodybuildersActivity : AppCompatActivity() {

    // Declare binding, but only for the inflation step
    private lateinit var binding: ActivityBodybuildersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inflate the layout (even if activity_bodybuilders.xml is minimal)
        binding = ActivityBodybuildersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // *** LOGIC REMOVED ***
        // Removed: setSupportActionBar(binding.toolbar)
        // Removed: supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Removed: supportActionBar?.title = "Bodybuilder Profiles"
        // This prevents the "Unresolved reference: toolbar" error.

        // If the Activity has a default ActionBar, this will still set the title:
        supportActionBar?.title = "Bodybuilder Profiles"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Note: If this Activity is supposed to display a list, you will need
        // to add a RecyclerView with ID 'recyclerView' to your XML later.
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}