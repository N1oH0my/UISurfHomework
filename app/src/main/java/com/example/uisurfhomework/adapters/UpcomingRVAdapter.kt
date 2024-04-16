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

class UpcomingRVAdapter(private val rocketList: List<RocketModel>) :
    RecyclerView.Adapter<UpcomingRVAdapter.UpcomingViewHolder>() {

    inner class UpcomingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val typeTextView: TextView = itemView.findViewById(R.id.typeText)
        val nameTextView: TextView = itemView.findViewById(R.id.nameText)
        val shortLaunchDateTextView: TextView = itemView.findViewById(R.id.shortLaunchDateText)
        val shortLaunchSiteTextView: TextView = itemView.findViewById(R.id.shortSiteText)

        val LaunchDateTextView: TextView = itemView.findViewById(R.id.launchDate)
        val LaunchSiteTextView: TextView = itemView.findViewById(R.id.launchSite)
        val countDownView: TextView = itemView.findViewById(R.id.countDown)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.upcomming_item, parent, false)
        return UpcomingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        val currentItem = rocketList[position]

        val packageName = holder.itemView.context.packageName
        val resourceId = holder.itemView.context.resources.getIdentifier(currentItem.img, "drawable", packageName)
        if (resourceId != 0) {
            Glide.with(holder.itemView)
                .load(resourceId)
                .into(holder.imageView)
            Log.e("UpcomingAdapter", "Resource found for item: ${currentItem.img}")
        } else {
            Log.e("UpcomingAdapter", "Resource not found for item: ${currentItem.img}")
        }

        holder.typeTextView.text = currentItem.type
        holder.nameTextView.text = currentItem.name
        holder.shortLaunchDateTextView.text = currentItem.shortlaunchDate
        holder.shortLaunchSiteTextView.text = currentItem.shortlaunchSite

        holder.LaunchDateTextView.text = currentItem.launchDate
        holder.LaunchSiteTextView.text = currentItem.launchSite
        holder.countDownView.text = currentItem.countDown

    }

    override fun getItemCount() = rocketList.size
}