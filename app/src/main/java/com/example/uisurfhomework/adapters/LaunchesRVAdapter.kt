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

class LaunchesRVAdapter(private val rocketList: List<RocketModel>) :
    RecyclerView.Adapter<LaunchesRVAdapter.LaunchesViewHolder>() {

    inner class LaunchesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val typeTextView: TextView = itemView.findViewById(R.id.typeText)
        val nameTextView: TextView = itemView.findViewById(R.id.nameText)
        val shortLaunchDateTextView: TextView = itemView.findViewById(R.id.shortLaunchDateText)
        val shortLaunchSiteTextView: TextView = itemView.findViewById(R.id.shortSiteText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.launch_item, parent, false)
        return LaunchesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LaunchesViewHolder, position: Int) {
        val currentItem = rocketList[position]

        val packageName = holder.itemView.context.packageName
        val resourceId = holder.itemView.context.resources.getIdentifier(currentItem.img, "drawable", packageName)
        if (resourceId != 0) {
            Glide.with(holder.itemView)
                .load(resourceId)
                .into(holder.imageView)
            Log.e("LaunchAdapter", "Resource found for item: ${currentItem.img}")
        } else {
            Log.e("LaunchAdapter", "Resource not found for item: ${currentItem.img}")
        }

        holder.typeTextView.text = currentItem.type
        holder.nameTextView.text = currentItem.name
        holder.shortLaunchDateTextView.text = currentItem.shortlaunchDate
        holder.shortLaunchSiteTextView.text = currentItem.shortlaunchSite

    }

    override fun getItemCount() = rocketList.size
}