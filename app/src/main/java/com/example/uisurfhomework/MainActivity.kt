package com.example.uisurfhomework

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.uisurfhomework.adapters.LaunchesRVAdapter
import com.example.uisurfhomework.adapters.RocketsRVAdapter
import com.example.uisurfhomework.adapters.UpcomingRVAdapter
import com.example.uisurfhomework.databinding.ActivityMainBinding
import com.example.uisurfhomework.models.RocketModel
import com.google.android.material.tabs.TabLayout

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

        val tabLayout: TabLayout = binding.mainTabLayout
        val tab1 = layoutInflater.inflate(R.layout.custom_tab, null) as TextView
        val tab2 = layoutInflater.inflate(R.layout.custom_tab, null) as TextView
        val tab3 = layoutInflater.inflate(R.layout.custom_tab, null) as TextView
        tab1.text = "Upcoming"
        tab1.setTextColor(resources.getColor(R.color.tabSelected))
        tabLayout.addTab(tabLayout.newTab().setCustomView(tab1))
        tab2.text = "Launches"
        tabLayout.addTab(tabLayout.newTab().setCustomView(tab2))
        tab3.text = "Rockets"
        tabLayout.addTab(tabLayout.newTab().setCustomView(tab3))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val customView = tab.customView as TextView?
                customView?.setTextColor(resources.getColor(R.color.tabSelected))
                when (tab.position) {
                    0 -> showUpcoming()
                    1 -> showLaunched()
                    2 -> showRockets()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val customView = tab.customView as TextView?
                customView?.setTextColor(resources.getColor(R.color.tabUnselected))
                when (tab.position) {
                    0 -> hideUpcoming()
                    1 -> hideLaunched()
                    2 -> hideRockets()
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        val rocketsList = generateRocketList()

        val forLaunchList = rocketsList.filter { it.isLaunch }
        val forRocketsList = rocketsList.filter { it.isRocket }
        val forUpcomingList = rocketsList.filter { it.isUpcoming }


        val recyclerViewUpcoming: RecyclerView = binding.tab1RecyclerView
        recyclerViewUpcoming.layoutManager = LinearLayoutManager(this)
        val adapterUp = UpcomingRVAdapter(forUpcomingList)
        recyclerViewUpcoming.adapter = adapterUp

        val recyclerViewLaunch: RecyclerView = binding.tab2RecyclerView
        recyclerViewLaunch.layoutManager = LinearLayoutManager(this)
        val adapterL = LaunchesRVAdapter(forLaunchList)
        recyclerViewLaunch.adapter = adapterL

        val recyclerViewRocket: RecyclerView = binding.tab3RecyclerView
        recyclerViewRocket.layoutManager = LinearLayoutManager(this)
        val adapterR = RocketsRVAdapter(forRocketsList)
        recyclerViewRocket.adapter = adapterR

        hideLaunched()
        hideRockets()
    }

    private fun hideRockets() {
        binding.tab3RecyclerView.visibility = View.GONE
    }

    private fun hideLaunched() {
        binding.tab2RecyclerView.visibility = View.GONE
    }

    private fun hideUpcoming() {
        binding.tab1RecyclerView.visibility = View.GONE
    }

    private fun showRockets() {
        binding.tab3RecyclerView.visibility = View.VISIBLE
    }

    private fun showLaunched() {
        binding.tab2RecyclerView.visibility = View.VISIBLE
    }

    private fun showUpcoming() {
        binding.tab1RecyclerView.visibility = View.VISIBLE
    }

    private fun generateRocketList(): List<RocketModel> {
        return listOf(
            RocketModel("starlinktwof", "LAUNCH", "Starlink 2", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 400", "5 Hrs 30mins more...", "ACTIVE", isUpcoming = true),
            RocketModel("bigfalconrocket", "ROCKET", "Big Falcon Rocket", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 42", "5 Hrs 30mins more...", "ACTIVE", isRocket = true),
            RocketModel("crstwo", "LAUNCH", "CRS - 2", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 44", "5 Hrs 30mins more...", "ACTIVE", isLaunch = true),
            RocketModel("demosat", "LAUNCH", "DemoSat", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 40", "5 Hrs 30mins more...", "ACTIVE", isUpcoming = true),
            RocketModel("falconone", "ROCKET", "Falcon 1", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 403", "5 Hrs 30mins more...", "INACTIVE", isRocket = true),
            RocketModel("falconnine", "LAUNCH", "Falcon 9", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 43", "5 Hrs 30mins more...", "ACTIVE", isRocket = true),
            RocketModel("bigfalconrocket", "ROCKET", "Big Falcon Rocket", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 42", "5 Hrs 30mins more...", "ACTIVE", isRocket = true),
            RocketModel("falconone", "ROCKET", "Falcon 1", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 403", "5 Hrs 30mins more...", "INACTIVE", isRocket = true),
            RocketModel("falconnine", "LAUNCH", "Falcon 9", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 43", "5 Hrs 30mins more...", "ACTIVE", isRocket = true),
            RocketModel("falconninetest", "ROCKET", "Falcon 9 Test", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 99", "5 Hrs 30mins more...", "ACTIVE", isLaunch = true),
            RocketModel("starlinktwo", "LAUNCH", "Starlink 2", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 45", "5 Hrs 30mins more...", "ACTIVE", isLaunch = true),
            RocketModel("crstwo", "LAUNCH", "CRS - 2", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 44", "5 Hrs 30mins more...", "ACTIVE", isLaunch = true),
            RocketModel("falconninetest", "ROCKET", "Falcon 9 Test", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 99", "5 Hrs 30mins more...", "ACTIVE", isLaunch = true),
            RocketModel("starlinktwof", "LAUNCH", "Starlink 2", "Thu Oct 17 5:30:00 2019", "Cape Canaveral Air Force Station Space Launch Complex 45", "5 Hrs 30mins more...", "ACTIVE", isLaunch = true),

        )
    }
}