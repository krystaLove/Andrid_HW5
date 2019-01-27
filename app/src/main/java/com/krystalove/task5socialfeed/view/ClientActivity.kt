package com.krystalove.task5socialfeed.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.krystalove.task5socialfeed.R
import com.krystalove.task5socialfeed.controller.adapters.FeedAdapter
import com.krystalove.task5socialfeed.model.Feed
import com.krystalove.task5socialfeed.model.Feed.News
import com.krystalove.task5socialfeed.model.ItemsData
import kotlinx.android.synthetic.main.activity_client.*

class ClientActivity : AppCompatActivity() {

    private lateinit var navigation: BottomNavigationView

    private var allItems = ItemsData.allItems.shuffled()
    private var myItems = emptyList<News>()
    private var newsItems = ItemsData.news.shuffled()
    private var notificationItems = ItemsData.notification.shuffled()
    private lateinit var feedAdapter: FeedAdapter

    private val GET_POST = 1

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
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 0)
                        fab.hide()
                    else
                        fab.show()
                }
            })
        }
        fab.setOnClickListener {
            startActivityForResult(Intent(this, NewPostActivity::class.java), GET_POST)
            overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data == null || requestCode!= GET_POST || resultCode!= Activity.RESULT_OK) return

        val title = data.getStringExtra("Title")
        val description = data.getStringExtra("Description")
        val bitmapUri = data.getStringExtra("ImageURI")

        myItems = listOf(News(null, title, description, false, bitmapUri, 0))
        allItems = myItems + allItems
        newsItems = myItems + newsItems
        when (navigation.selectedItemId) {
            R.id.navigation_feed -> refreshData(allItems)
            R.id.navigation_news -> refreshData(newsItems)
        }
    }

    private fun refreshData(items: List<Feed>) {
        feedAdapter.setData(items)
        feedAdapter.notifyDataSetChanged()
    }
}