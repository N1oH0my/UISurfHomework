package com.example.uisurfhomework.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.uisurfhomework.models.RocketModel
import com.example.uisurfhomework.views.fragments.AnimationsFragment
import com.example.uisurfhomework.views.fragments.LaunchFragment
import com.example.uisurfhomework.views.fragments.RocketsFragment
import com.example.uisurfhomework.views.fragments.UpcomingFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val rocketLists: List<MutableList<RocketModel>>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = rocketLists.size + 1
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return UpcomingFragment.newInstance(rocketLists[position])
            1 -> return LaunchFragment.newInstance(rocketLists[position])
            2 -> return RocketsFragment.newInstance(rocketLists[position])
            3 -> return AnimationsFragment()
        }
        return UpcomingFragment.newInstance(rocketLists[position])
    }
}
