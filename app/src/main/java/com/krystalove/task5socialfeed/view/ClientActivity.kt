package com.krystalove.task5socialfeed.view

import android.os.Bundle
import androidx.annotation.DrawableRes
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.krystalove.task5socialfeed.R
import com.krystalove.task5socialfeed.view.fragments.FeedFragment
import com.krystalove.task5socialfeed.view.fragments.NewsFragment
import com.krystalove.task5socialfeed.view.fragments.NotificationFragment
import kotlinx.android.synthetic.main.activity_client.*

class ClientActivity : AppCompatActivity() {

    private lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        navigation = findViewById(R.id.navigation)
        setFragment(R.id.navigation_feed)
        navigation.selectedItemId = R.id.navigation_feed
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        if (item.itemId == navigation.selectedItemId) return@OnNavigationItemSelectedListener false
        setFragment(item.itemId)
        when (item.itemId) {
            R.id.navigation_feed -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_news -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun setFragment(id: Int) {
        changeCollapsingToolbarImage(id)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = when (id) {
            R.id.navigation_feed -> FeedFragment()
            R.id.navigation_news -> NewsFragment()
            else -> NotificationFragment()
        }
        fragmentTransaction.replace(R.id.client_container, fragment)
        fragmentTransaction.commit()
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