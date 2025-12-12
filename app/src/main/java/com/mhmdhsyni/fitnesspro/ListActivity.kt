package com.fitnesspro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.fitnesspro.databinding.ActivityListBinding
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val type = intent.getStringExtra("TYPE") ?: ""
        val group = intent.getStringExtra("GROUP") // Only set for exercises

        // 1. Load and Filter Data based on TYPE and GROUP
        val (finalArray, itemType) = loadData(type, group)

        // Set screen title (e.g., "Injuries" or "Chest")
        title = group ?: type.replaceFirstChar { it.uppercase() }

        // 2. Extract names for the list view
        val names = ArrayList<String>()
        for (i in 0 until finalArray.length()) {
            names.add(finalArray.getJSONObject(i).optString("name"))
        }

        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

        // 3. Handle Clicks: Route to the appropriate detail screen
        binding.listView.setOnItemClickListener { _, _, _, position ->
            val itemData = finalArray.getJSONObject(position)

            when (itemType) {
                "exercises" -> {
                    // Route to the complex Exercise Detail screen
                    val intent = Intent(this, ExerciseDetailActivity::class.java)
                    intent.putExtra("EXERCISE_JSON", itemData.toString()) // Sends the full JSON object as a string
                    startActivity(intent)
                }
                "nutrition" -> {
                    // Custom formatting for Nutrition data (Cal, Protein, Carbs, Fat)
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("TITLE", itemData.optString("name"))

                    val content = buildString {
                        append("Calories: ${itemData.optString("calories", "N/A")}\n")
                        append("Protein: ${itemData.optString("protein", "N/A")}\n")
                        append("Carbs: ${itemData.optString("carbs", "N/A")}\n")
                        append("Fat: ${itemData.optString("fat", "N/A")}\n\n")
                        append("Description: ${itemData.optString("description", "")}")
                    }

                    intent.putExtra("CONTENT", content)
                    startActivity(intent)
                }
                else -> {
                    // Generic handler for Injury/Supplement/Gyms
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("TITLE", itemData.optString("name"))

                    val content = itemData.optString("instructions",
                        itemData.optString("description",
                            itemData.optString("explanation", "")))

                    intent.putExtra("CONTENT", content)
                    startActivity(intent)
                }
            }
        }
    }

    // Loads the correct JSON file based on the 'type'
    private fun loadData(type: String, group: String?): Pair<JSONArray, String> {
        return when (type) {
            "exercises" -> Pair(getExercisesForGroup(group), "exercises")
            "injuries" -> Pair(loadJson("injuries"), "injuries")
            "supplements" -> Pair(loadJson("supplements"), "supplements")
            "gyms" -> Pair(loadJson("gyms"), "gyms")
            "nutrition" -> Pair(loadJson("food_database"), "nutrition")
            else -> Pair(JSONArray(), "unknown")
        }
    }

    // Filters the main exercises_grouped.json file by the specific muscle group
    private fun getExercisesForGroup(groupName: String?): JSONArray {
        if (groupName.isNullOrEmpty()) return JSONArray()

        val allGroups = loadJson("exercises_grouped")
        for (i in 0 until allGroups.length()) {
            val groupObj = allGroups.getJSONObject(i)
            if (groupObj.optString("group") == groupName) {
                return groupObj.optJSONArray("exercises") ?: JSONArray()
            }
        }
        return JSONArray()
    }

    // Utility function (safely loading JSON)
    private fun loadJson(filename: String): JSONArray {
        try {
            val inputStream = assets.open("data/$filename.json")
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            return JSONArray(jsonString)
        } catch (e: Exception) {
            Log.e("ListActivity", "Error loading JSON for $filename: ${e.message}")
            return JSONArray()
        }
    }
}