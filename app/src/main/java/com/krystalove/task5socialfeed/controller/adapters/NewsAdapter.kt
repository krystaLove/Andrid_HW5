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
import com.krystalove.task5socialfeed.model.News
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(activity: Activity) : AdapterDelegate<List<Any>>() {

    private val mInflater: LayoutInflater = activity.layoutInflater

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        NewsHolder(
            mInflater.inflate(
                R.layout.news_item,
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
        val vh = holder as NewsHolder
        val news = items[position] as News
        Glide.with(mInflater.context)
            .load(news.logoId)
            .into(vh.newsImage)
        vh.newsDescription.text = news.description
        vh.newsTitle.text = news.title
    }

    override fun isForViewType(items: List<Any>, position: Int): Boolean = items[position] is News

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsImage: ImageView = itemView.news_image
        val newsTitle: TextView = itemView.news_title
        val newsDescription: TextView = itemView.news_description
    }
}