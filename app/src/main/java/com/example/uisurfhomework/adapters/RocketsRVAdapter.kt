package com.example.uisurfhomework.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uisurfhomework.R
import com.example.uisurfhomework.models.RocketModel

class RocketsRVAdapter(private val rocketList: List<RocketModel>) :
    RecyclerView.Adapter<RocketsRVAdapter.RocketViewHolder>() {

    inner class RocketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val typeTextView: TextView = itemView.findViewById(R.id.typeText)
        val nameTextView: TextView = itemView.findViewById(R.id.nameText)
        val statusTextView: TextView = itemView.findViewById(R.id.shortSiteText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rocket_item, parent, false)
        return RocketViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        val currentItem = rocketList[position]

        val packageName = holder.itemView.context.packageName
        val resourceId = holder.itemView.context.resources.getIdentifier(currentItem.img, "drawable", packageName)
        if (resourceId != 0) {
            Glide.with(holder.itemView)
                .load(resourceId)
                .into(holder.imageView)
            Log.e("RocketAdapter", "Resource found for item: ${currentItem.img}")
        } else {
            Log.e("RocketAdapter", "Resource not found for item: ${currentItem.img}")
        }

        holder.typeTextView.text = currentItem.type
        holder.nameTextView.text = currentItem.name
        holder.statusTextView.text = currentItem.status
        if (currentItem.status == "INACTIVE"){
            holder.statusTextView.setBackgroundResource(R.drawable.inactive_status_rounded_corners)
        }
        else if(currentItem.status == "ACTIVE"){
            holder.statusTextView.setBackgroundResource(R.drawable.active_status_rounded_corners)
        }

    }

    override fun getItemCount() = rocketList.size
}