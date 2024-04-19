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
import com.example.uisurfhomework.adapters.RocketsRVAdapter
import com.example.uisurfhomework.adapters.UpcomingRVAdapter
import com.example.uisurfhomework.databinding.FragmentRocketsBinding
import com.example.uisurfhomework.databinding.FragmentUpcomingBinding
import com.example.uisurfhomework.models.RocketModel


class RocketsFragment : Fragment() {

    private val binding by viewBinding(FragmentRocketsBinding::bind)
    private val rocketsList: MutableList<RocketModel> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getParcelableArrayList<RocketModel>(ARG_ROCKETS_LIST)?.let { list ->
            rocketsList.addAll(list)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rockets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewRocket: RecyclerView = binding.tab3RecyclerView
        recyclerViewRocket.layoutManager = LinearLayoutManager(requireContext())
        val adapterR = RocketsRVAdapter(rocketsList)
        recyclerViewRocket.adapter = adapterR

    }

    companion object {

        const val ARG_ROCKETS_LIST = "rocketsList"
        @JvmStatic
        fun newInstance(rocketList: MutableList<RocketModel>): RocketsFragment {
            val fragment = RocketsFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_ROCKETS_LIST, ArrayList(rocketList))
            fragment.arguments = args
            return fragment
        }
    }
}