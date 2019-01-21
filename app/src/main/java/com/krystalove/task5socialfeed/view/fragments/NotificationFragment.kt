package com.krystalove.task5socialfeed.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.krystalove.task5socialfeed.R
import com.krystalove.task5socialfeed.controller.NotificationAdapter
import com.krystalove.task5socialfeed.model.Notification

class NotificationFragment : Fragment() {

    companion object {

        fun newInstance(): NotificationFragment {
            return NotificationFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        val notificationAdapter = NotificationAdapter(context!!, notifications)

        val recyclerView = view.findViewById<RecyclerView>(R.id.notification_recyclerView)
        recyclerView.apply {
            setHasOptionsMenu(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = notificationAdapter

        }

        return view
    }
    private val notifications by lazy {
        listOf(
            Notification(android.R.drawable.alert_dark_frame, "Title", "Notification"),
            Notification(android.R.drawable.alert_dark_frame, "Title", "Notification"),
            Notification(android.R.drawable.alert_dark_frame, "Title", "Notification"),
            Notification(android.R.drawable.alert_dark_frame, "Title", "Notification"),
            Notification(android.R.drawable.alert_dark_frame, "Title", "Notification"),
            Notification(android.R.drawable.alert_dark_frame, "Title", "Notification"),
            Notification(android.R.drawable.alert_dark_frame, "Title", "Notification"),
            Notification(android.R.drawable.alert_dark_frame, "Title", "Notification"),
            Notification(android.R.drawable.alert_dark_frame, "Title", "Notification"),
            Notification(android.R.drawable.alert_dark_frame, "Title", "Notification")
        )
    }
}