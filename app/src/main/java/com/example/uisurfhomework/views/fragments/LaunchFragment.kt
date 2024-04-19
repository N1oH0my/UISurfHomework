package com.example.uisurfhomework.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.uisurfhomework.R
import com.example.uisurfhomework.adapters.LaunchesRVAdapter
import com.example.uisurfhomework.adapters.UpcomingRVAdapter
import com.example.uisurfhomework.databinding.FragmentLaunchBinding
import com.example.uisurfhomework.databinding.FragmentRocketsBinding
import com.example.uisurfhomework.models.RocketModel


class LaunchFragment : Fragment() {

    private val binding by viewBinding(FragmentLaunchBinding::bind)
    private val launchList: MutableList<RocketModel> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_launch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelableArrayList<RocketModel>(ARG_LAUNCH_LIST)?.let { list ->
            launchList.addAll(list)
        }
        val recyclerViewLaunch: RecyclerView = binding.tab2RecyclerView
        recyclerViewLaunch.layoutManager = LinearLayoutManager(requireContext())
        val adapterL = LaunchesRVAdapter(launchList)
        recyclerViewLaunch.adapter = adapterL

    }

    companion object {

        const val ARG_LAUNCH_LIST = "launchList"
        @JvmStatic
        fun newInstance(rocketList: MutableList<RocketModel>): LaunchFragment {
            val fragment = LaunchFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_LAUNCH_LIST, ArrayList(rocketList))
            fragment.arguments = args
            return fragment
        }
    }
}