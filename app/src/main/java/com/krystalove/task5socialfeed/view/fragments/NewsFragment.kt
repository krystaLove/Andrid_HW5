package com.krystalove.task5socialfeed.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.krystalove.task5socialfeed.R
import com.krystalove.task5socialfeed.controller.NewsAdapter
import com.krystalove.task5socialfeed.model.News

class NewsFragment : Fragment() {

    companion object {

        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        val newsAdapter = NewsAdapter(context!!, news)

        val recyclerView = view.findViewById<RecyclerView>(R.id.news_recyclerView)
        recyclerView.apply {
            setHasOptionsMenu(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = newsAdapter

        }

        return view
    }

    private val news by lazy {
        listOf(

            News(android.R.drawable.alert_dark_frame, "Title", "Description"),
            News(android.R.drawable.alert_dark_frame, "Title", "Description"),
            News(android.R.drawable.alert_dark_frame, "Title", "Description"),
            News(android.R.drawable.alert_dark_frame, "Title", "Description"),
            News(android.R.drawable.alert_dark_frame, "Title", "Description"),
            News(android.R.drawable.alert_dark_frame, "Title", "Description"),
            News(android.R.drawable.alert_dark_frame, "Title", "Description")
        )
    }

}