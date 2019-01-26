package com.krystalove.task5socialfeed.controller.adapters

import android.app.Activity
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.krystalove.task5socialfeed.model.Feed

class FeedAdapter(activity: Activity, items: List<Feed>) : ListDelegationAdapter<List<Feed>>() {
    init {
        delegatesManager.addDelegate(NotificationAdapter(activity))
        delegatesManager.addDelegate(NewsAdapter(activity))
        setItems(items)
    }
    fun setData(items: List<Feed>){
        setItems(items)
    }
}