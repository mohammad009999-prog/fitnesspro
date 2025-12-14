package com.mhmdhsyni.fitnesspro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// NOTE: This adapter is assumed to be used for the list views (ListActivity).

class MuscleGroupAdapter(
    // Accepts the list of items
    private val itemList: List<Any>,
    private val itemClickListener: (String) -> Unit
) : RecyclerView.Adapter<MuscleGroupAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // --- CRITICAL FIX: Changed IDs from item_title/description to list_item_title/description ---
        val titleTextView: TextView = itemView.findViewById(R.id.list_item_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.list_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            // Layout name is assumed to be list_item_layout.xml
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