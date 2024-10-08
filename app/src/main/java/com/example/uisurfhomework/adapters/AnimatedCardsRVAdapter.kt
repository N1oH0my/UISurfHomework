package com.example.uisurfhomework.adapters

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uisurfhomework.R

class AnimatedCardsRVAdapter(private val items: List<String>) :
    RecyclerView.Adapter<AnimatedCardsRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.animated_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemText.text = items[position]
        holder.arrowButton.rotation = 0f
        holder.itemText.textSize = 18f
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemText: TextView = view.findViewById(R.id.item_text)
        val arrowButton: ImageView = view.findViewById(R.id.arrow_button)

        init {
            arrowButton.setOnClickListener {
                val targetRotation = if (arrowButton.rotation == 0f) 180f else 0f
                arrowButton.animate()
                    .rotation(targetRotation)
                    .setDuration(200)
                    .start()
            }
            itemText.setOnClickListener {
                val currentSizeSp =
                    itemText.textSize / itemText.resources.displayMetrics.scaledDensity
                val newSizeSp = if (currentSizeSp == 18f) 24f else 18f

                val animator = ValueAnimator.ofFloat(currentSizeSp, newSizeSp)
                animator.duration = 200
                animator.addUpdateListener { animation ->
                    val animatedValue = animation.animatedValue as Float
                    itemText.setTextSize(TypedValue.COMPLEX_UNIT_SP, animatedValue)
                }
                animator.start()
            }
        }
    }
}


