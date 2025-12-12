package com.fitnesspro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fitnesspro.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("TITLE")
        val content = intent.getStringExtra("CONTENT")

        // Set the screen title (e.g., "Creatine Monohydrate")
        this.title = title

        // Display the detailed content
        binding.tvContent.text = content
    }
}