package com.mhmdhsyni.fitnesspro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// NOTE: This adapter is used by ListActivity.kt to display all data categories.

class ListAdapter(
    // Accepts the safely cast generic List<Any> from ListActivity
    private val itemList: List<Any>,
    private val itemClickListener: (String) -> Unit
) : RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // --- IDs MUST match your list_item_layout.xml ---
        val titleTextView: TextView = itemView.findViewById(R.id.list_item_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.list_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            // Layout file name is list_item_layout.xml
            .inflate(R.layout.list_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]

        when (item) {
            is FitnessItem -> {
                holder.titleTextView.text = item.title
                holder.descriptionTextView.text = item.category
                holder.itemView.setOnClickListener { itemClickListener(item.title) }
            }
            is FoodItem -> {
                holder.titleTextView.text = item.title
                holder.descriptionTextView.text = "Calories: ${item.calories} | Protein: ${item.protein}"
                holder.itemView.setOnClickListener { itemClickListener(item.title) }
            }
            is BodybuilderProfile -> {
                holder.titleTextView.text = item.title
                holder.descriptionTextView.text = item.description
                holder.itemView.setOnClickListener { itemClickListener(item.title) }
            }
            else -> {
                holder.titleTextView.text = "Error Item"
                holder.descriptionTextView.text = "Unknown Data Type"
            }
        }
    }

    override fun getItemCount() = itemList.size
}