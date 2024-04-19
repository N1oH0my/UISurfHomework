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
import com.example.uisurfhomework.adapters.UpcomingRVAdapter
import com.example.uisurfhomework.databinding.ActivityMainBinding
import com.example.uisurfhomework.databinding.FragmentUpcomingBinding
import com.example.uisurfhomework.models.RocketModel

class UpcomingFragment : Fragment() {

    private val binding by viewBinding(FragmentUpcomingBinding::bind)
    private val upcomingList: MutableList<RocketModel> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getParcelableArrayList<RocketModel>(ARG_UPCOMING_LIST)?.let { list ->
            upcomingList.addAll(list)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerViewUpcoming: RecyclerView = binding.tab1RecyclerView
        recyclerViewUpcoming.layoutManager = LinearLayoutManager(requireContext())
        val adapterUp = UpcomingRVAdapter(upcomingList)
        recyclerViewUpcoming.adapter = adapterUp

    }

    companion object {

        const val ARG_UPCOMING_LIST = "upcomingList"
        @JvmStatic
        fun newInstance(rocketList: MutableList<RocketModel>): UpcomingFragment {
            val fragment = UpcomingFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_UPCOMING_LIST, ArrayList(rocketList))
            fragment.arguments = args
            return fragment
        }
    }
}