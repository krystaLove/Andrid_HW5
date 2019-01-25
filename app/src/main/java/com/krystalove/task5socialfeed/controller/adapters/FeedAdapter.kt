package com.krystalove.task5socialfeed.controller.adapters

import android.app.Activity
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class FeedAdapter(activity: Activity, items: List<Any>) : ListDelegationAdapter<List<Any>>() {
    init {
        delegatesManager.addDelegate(NotificationAdapter(activity))
        delegatesManager.addDelegate(NewsAdapter(activity))
        setItems(items)
    }
}