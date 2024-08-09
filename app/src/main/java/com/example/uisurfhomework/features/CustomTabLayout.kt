package com.example.uisurfhomework.features

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.uisurfhomework.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CustomTabLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TabLayout(context, attrs, defStyleAttr) {

    init {
        addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: Tab?) {
                tab?.customView?.let { view ->
                    updateTab(view, true)
                }
            }

            override fun onTabUnselected(tab: Tab?) {
                tab?.customView?.let { view ->
                    updateTab(view, false)
                }
            }

            override fun onTabReselected(tab: Tab?) {}
        })
    }

    fun setupWithViewPager(
        viewPager: ViewPager2,
        tabTitles: List<String>,
        selectedColorRes: Int,
        unselectedColorRes: Int
    ) {
        val inflater = LayoutInflater.from(context)

        viewPager.adapter?.let {
            TabLayoutMediator(this, viewPager) { tab, position ->
                val tabView = inflater.inflate(R.layout.custom_tab, null)
                val tabTextView = tabView.findViewById<TextView>(R.id.tabText)
                tabTextView.text = tabTitles[position]
                tab.customView = tabView

                if (position == 0) {
                    tabTextView.setTextColor(context.getColor(selectedColorRes))
                } else {
                    tabTextView.setTextColor(context.getColor(unselectedColorRes))
                }
            }.attach()

            for (i in tabTitles.indices) {
                getTabAt(i)?.customView?.let { view ->
                    updateTab(view, i == 0)
                }
            }
        }
    }

    private fun updateTab(view: View, isSelected: Boolean) {
        val textView = view.findViewById<TextView>(R.id.tabText)
        val colorRes = if (isSelected) R.color.tabSelected else R.color.tabUnselected
        textView.setTextColor(context.getColor(colorRes))
    }
}
