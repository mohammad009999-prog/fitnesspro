package com.mhmdhsyni.fitnesspro // Corrected package

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// ListActivity now inherits from LanguageActivity (the correct base class)
class ListActivity : LanguageActivity(), FitnessAdapter.OnItemClickListener {

    companion object {
        const val LIST_CATEGORY = "list_category"
        private const val TAG = "ListActivity"
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FitnessAdapter
    private lateinit var categoryTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list) // Assumes this layout exists

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 1. Get the category title passed from the previous activity
        categoryTitle = intent.getStringExtra(LIST_CATEGORY) ?: "Category"
        title = categoryTitle // Set the Activity title bar

        // 2. Prepare the data list
        val fitnessItems = FitnessData.getListByCategory(categoryTitle)

        if (fitnessItems.isEmpty()) {
            Log.w(TAG, "No items found for category: $categoryTitle")
            Toast.makeText(this, "No data found for this category.", Toast.LENGTH_LONG).show()
        }

        // 3. Setup RecyclerView
        // NOTE: Ensure your activity_list.xml has an ID: @+id/recycler_view_list
        recyclerView = findViewById(R.id.recycler_view_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 4. Setup Adapter
        adapter = FitnessAdapter(fitnessItems, this)
        recyclerView.adapter = adapter
    }

    // Handle clicks on items in the RecyclerView
    override fun onItemClick(item: BaseFitnessItem) {
        val intent: Intent

        if (FitnessData.isExerciseCategory(categoryTitle)) {
            intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DETAIL_TITLE, item.title)
        } else {
            intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DETAIL_TITLE, item.title)
        }

        startActivity(intent)
    }

    // Enables the Up button functionality
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}

// ====================================================================
// MERGED FITNESS ADAPTER CONTENT
// ====================================================================

// This class definition is required by ListActivity
class FitnessAdapter(
    private val items: List<BaseFitnessItem>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<FitnessAdapter.ItemViewHolder>() {

    // 1. Define the interface for item clicks
    interface OnItemClickListener {
        fun onItemClick(item: BaseFitnessItem)
    }

    // 2. ViewHolder class
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // These IDs must match list_item_fitness.xml
        val title: TextView = itemView.findViewById(R.id.item_title)
        val subtitle: TextView = itemView.findViewById(R.id.item_subtitle)
        val image: ImageView = itemView.findViewById(R.id.item_image)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(items[position])
                }
            }
        }

        fun bind(item: BaseFitnessItem) {
            title.text = item.title

            val subtitleText = when (item) {
                is FitnessItem -> item.category
                is FoodItem -> "Calories: ${item.calories}"
                is BodybuilderProfile -> item.careerHighlights
                else -> item.description
            }
            subtitle.text = subtitleText

            val imageResId = when (item) {
                is FitnessItem -> item.imageResource
                is FoodItem -> item.imageResource
                is BodybuilderProfile -> item.imageResource
                else -> 0
            }
            if (imageResId != 0) {
                image.setImageResource(imageResId)
                image.visibility = View.VISIBLE
            } else {
                image.visibility = View.GONE
            }
        }
    }

    // 3. Create ViewHolder (inflates the layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // This layout name must exist in res/layout/
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_fitness, parent, false)
        return ItemViewHolder(view)
    }

    // 4. Bind data to ViewHolder
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    // 5. Get item count
    override fun getItemCount() = items.size
}