package com.example.uisurfhomework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uisurfhomework.R
import com.example.uisurfhomework.adapters.AnimatedCardsRVAdapter

class AnimationsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: AnimatedCardsRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_animations, container, false)
        
        return view
    }

}