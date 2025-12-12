package com.fitnesspro

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.fitnesspro.databinding.ActivityListBinding
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader

class ExerciseGroupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Binds the ActivityListBinding to the list layout (activity_list.xml)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sets the screen title from multilingual resources (R.string.exercises)
        title = getString(R.string.exercises)

        val jsonArray = loadJson("exercises_grouped")

        // Extracts only the group names (Chest, Back, Legs)
        val groupNames = ArrayList<String>()
        for (i in 0 until jsonArray.length()) {
            groupNames.add(jsonArray.getJSONObject(i).optString("group"))
        }

        // Displays the group names in the ListView
        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, groupNames)

        // Handles click on a group name
        binding.listView.setOnItemClickListener { _, _, position, _ ->
            val selectedGroup = groupNames[position]
            val intent = Intent(this, ListActivity::class.java)

            // Sends the type and the selected group name to ListActivity
            intent.putExtra("TYPE", "exercises")
            intent.putExtra("GROUP", selectedGroup)
            startActivity(intent)
        }
    }

    // Utility function to safely load JSON from the assets/data folder
    private fun loadJson(filename: String): JSONArray {
        return try {
            val inputStream = assets.open("data/$filename.json")
            val reader = inputStream.bufferedReader()
            val jsonString = reader.use { it.readText() }
            JSONArray(jsonString)
        } catch (e: Exception) {
            // Returns an empty array if the file is missing or corrupted
            JSONArray()
        }
    }
}