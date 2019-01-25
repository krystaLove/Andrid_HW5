package com.krystalove.task5socialfeed.controller.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.krystalove.task5socialfeed.R
import com.krystalove.task5socialfeed.model.Notification
import kotlinx.android.synthetic.main.notification_item.view.*

class NotificationAdapter(activity: Activity) : AdapterDelegate<List<Any>>() {

    private val mInflater: LayoutInflater = activity.layoutInflater

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        NotificationHolder(
            mInflater.inflate(
                R.layout.notification_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(
        items: List<Any>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val vh = holder as NotificationHolder
        val notification = items[position] as Notification
        vh.notificationDescription.text = notification.notification
        vh.notificationTitle.text = notification.title
        Glide.with(mInflater.context)
            .load(notification.logoId)
            .into(vh.notificationImage)
    }

    override fun isForViewType(items: List<Any>, position: Int) = items[position] is Notification

    class NotificationHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val notificationImage: ImageView = itemView.notification_image
        val notificationTitle: TextView = itemView.notification_title
        val notificationDescription: TextView = itemView.notification_description
    }
}