package com.example.uisurfhomework

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.uisurfhomework.adapters.ViewPagerAdapter
import com.example.uisurfhomework.databinding.ActivityMainBinding
import com.example.uisurfhomework.models.RocketModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mainRocketsList = generateRocketList()

        val forLaunchList = mainRocketsList.filter { it.isLaunch }.toMutableList()
        val forRocketsList = mainRocketsList.filter { it.isRocket }.toMutableList()
        val forUpcomingList = mainRocketsList.filter { it.isUpcoming }.toMutableList()

        val filteredRocketsLists = listOf(forUpcomingList, forLaunchList, forRocketsList)

        val viewPager: ViewPager2 = binding.viewPager
        val viewPageAdapter = ViewPagerAdapter(this, filteredRocketsLists)
        viewPager.adapter = viewPageAdapter

        val tabLayout: TabLayout = binding.mainTabLayout
        val tabTitles = listOf("Upcoming", "Launches", "Rockets", "Animated")

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        for (i in tabTitles.indices) {
            val tabView = layoutInflater.inflate(R.layout.custom_tab, null)
            val tabTextView = tabView.findViewById<TextView>(R.id.tabText)
            tabTextView.text = tabTitles[i]
            tabLayout.getTabAt(i)?.customView = tabView

            if (i == 0) {
                tabTextView.setTextColor(resources.getColor(R.color.tabSelected))
            }
        }


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val customView = tab.customView as TextView?
                customView?.setTextColor(resources.getColor(R.color.tabSelected))
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val customView = tab.customView as TextView?
                customView?.setTextColor(resources.getColor(R.color.tabUnselected))
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {}
        })

    }


    private fun generateRocketList(): MutableList<RocketModel> {
        return mutableListOf(
            RocketModel(
                "starlinktwof",
                "LAUNCH",
                "Starlink 2",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 400",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isUpcoming = true
            ),
            RocketModel(
                "bigfalconrocket",
                "ROCKET",
                "Big Falcon Rocket",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 42",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isRocket = true
            ),
            RocketModel(
                "crstwo",
                "LAUNCH",
                "CRS - 2",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 44",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isLaunch = true
            ),
            RocketModel(
                "demosat",
                "LAUNCH",
                "DemoSat",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 40",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isUpcoming = true
            ),
            RocketModel(
                "falconone",
                "ROCKET",
                "Falcon 1",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 403",
                "5 Hrs 30mins more...",
                "INACTIVE",
                isRocket = true
            ),
            RocketModel(
                "falconnine",
                "LAUNCH",
                "Falcon 9",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 43",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isRocket = true
            ),
            RocketModel(
                "bigfalconrocket",
                "ROCKET",
                "Big Falcon Rocket",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 42",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isRocket = true
            ),
            RocketModel(
                "falconone",
                "ROCKET",
                "Falcon 1",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 403",
                "5 Hrs 30mins more...",
                "INACTIVE",
                isRocket = true
            ),
            RocketModel(
                "falconnine",
                "LAUNCH",
                "Falcon 9",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 43",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isRocket = true
            ),
            RocketModel(
                "falconninetest",
                "ROCKET",
                "Falcon 9 Test",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 99",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isLaunch = true
            ),
            RocketModel(
                "starlinktwo",
                "LAUNCH",
                "Starlink 2",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 45",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isLaunch = true
            ),
            RocketModel(
                "crstwo",
                "LAUNCH",
                "CRS - 2",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 44",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isLaunch = true
            ),
            RocketModel(
                "falconninetest",
                "ROCKET",
                "Falcon 9 Test",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 99",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isLaunch = true
            ),
            RocketModel(
                "starlinktwof",
                "LAUNCH",
                "Starlink 2",
                "Thu Oct 17 5:30:00 2019",
                "Cape Canaveral Air Force Station Space Launch Complex 45",
                "5 Hrs 30mins more...",
                "ACTIVE",
                isLaunch = true
            ),

            )
    }
}