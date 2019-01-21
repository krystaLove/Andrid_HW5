package com.krystalove.task5socialfeed.controller

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krystalove.task5socialfeed.R
import com.krystalove.task5socialfeed.model.Notification
import kotlinx.android.synthetic.main.notification_item.view.*

class NotificationAdapter(context: Context, data: List<Notification>) : RecyclerView.Adapter<NotificationAdapter.NotificationHolder>() {
    override fun getItemCount(): Int = mNotificationData.size

    private val mInflater: LayoutInflater
    private var mNotificationData: List<Notification>

    init {
        this.mInflater = LayoutInflater.from(context)
        this.mNotificationData = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationHolder {
        val view = mInflater.inflate(R.layout.notification_item, parent, false)
        return NotificationHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationHolder, position: Int) {
        val notification = mNotificationData[position]
        holder.notificationDescription.text = notification.notification
        holder.notificationImage.setImageBitmap(BitmapFactory.decodeResource(mInflater.context.resources, notification.logoId))
        holder.notificationTitle.text = notification.title
    }

    class NotificationHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var notificationImage = itemView.notification_image
        var notificationTitle = itemView.notification_title
        var notificationDescription = itemView.notification_description

    }

}