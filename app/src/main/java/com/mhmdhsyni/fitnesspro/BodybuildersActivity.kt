package com.fitnesspro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fitnesspro.databinding.ActivityListBinding
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class BodybuildersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var bodybuildersList: ArrayList<JSONObject>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = getString(R.string.bodybuilders)

        bodybuildersList = loadData()

        // Use the custom adapter to display the names and images
        binding.listView.adapter = BodybuilderAdapter(this, bodybuildersList)

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            val selectedBodybuilder = bodybuildersList[position]

            // Route to DetailActivity (since it only displays text details)
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("TITLE", selectedBodybuilder.optString("name"))
            intent.putExtra("CONTENT", selectedBodybuilder.optString("details"))
            startActivity(intent)
        }
    }

    private fun loadData(): ArrayList<JSONObject> {
        val list = ArrayList<JSONObject>()
        try {
            val inputStream = assets.open("data/bodybuilders.json")
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                list.add(jsonArray.getJSONObject(i))
            }
        } catch (e: Exception) {
            // Handle error silently
        }
        return list
    }

    // Custom Adapter class to handle image loading
    private inner class BodybuilderAdapter(context: Context, items: ArrayList<JSONObject>) :
        ArrayAdapter<JSONObject>(context, 0, items) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var view = convertView
            val item = getItem(position)

            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.list_item_bodybuilder, parent, false)
            }

            val tvName = view!!.findViewById<TextView>(R.id.tvBodybuilderName)
            val ivImage = view.findViewById<ImageView>(R.id.ivBodybuilderImage)

            tvName.text = item?.optString("name")

            // Get the resource ID for the drawable image (e.g., R.drawable.arnold)
            val imageName = item?.optString("image")
            val imageResId = context.resources.getIdentifier(imageName, "drawable", context.packageName)

            if (imageResId != 0) {
                ivImage.setImageResource(imageResId)
            }
            return view
        }
    }
}