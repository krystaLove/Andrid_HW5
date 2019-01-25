package com.krystalove.task5socialfeed.view.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.krystalove.task5socialfeed.R
import com.krystalove.task5socialfeed.controller.adapters.FeedAdapter
import com.krystalove.task5socialfeed.model.ItemsData

class NewsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.news_recyclerView)
        recyclerView.apply {
            setHasOptionsMenu(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = FeedAdapter(
                activity as Activity,
                ItemsData.news.shuffled()
            )
        }
        return view
    }
}