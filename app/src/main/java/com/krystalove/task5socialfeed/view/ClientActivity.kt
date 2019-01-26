package com.krystalove.task5socialfeed.view

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.krystalove.task5socialfeed.R
import com.krystalove.task5socialfeed.controller.adapters.FeedAdapter
import com.krystalove.task5socialfeed.model.ItemsData
import kotlinx.android.synthetic.main.activity_client.*

class ClientActivity : AppCompatActivity() {

    private lateinit var navigation: BottomNavigationView

    private val allItems = ItemsData.allItems.shuffled()
    private val newsItems = ItemsData.news.shuffled()
    private val notificationItems = ItemsData.notification.shuffled()
    private lateinit var feedAdapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        navigation = findViewById(R.id.navigation)
        navigation.selectedItemId = R.id.navigation_feed
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        feedAdapter = FeedAdapter(
            this@ClientActivity,
            allItems
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ClientActivity)
            adapter = feedAdapter
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        if (item.itemId == navigation.selectedItemId) return@OnNavigationItemSelectedListener false
        changeCollapsingToolbarImage(item.itemId)
        when (item.itemId) {
            R.id.navigation_feed -> {
                feedAdapter.setData(allItems)
                feedAdapter.notifyDataSetChanged()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_news -> {
                feedAdapter.setData(newsItems)
                feedAdapter.notifyDataSetChanged()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                feedAdapter.setData(notificationItems)
                feedAdapter.notifyDataSetChanged()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun changeCollapsingToolbarImage(id: Int) {
        @DrawableRes val imageId = when (id) {
            R.id.navigation_feed -> R.drawable.feed
            R.id.navigation_news -> R.drawable.news
            else -> R.drawable.notification
        }
        Glide.with(this)
            .load(imageId)
            .into(collapsing_toolbar_image)
    }
}