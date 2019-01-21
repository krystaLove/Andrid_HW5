package com.krystalove.task5socialfeed.controller

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krystalove.task5socialfeed.R
import com.krystalove.task5socialfeed.model.News
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(context: Context, data: List<News>) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    override fun getItemCount(): Int = mNewsData.size

    private val mInflater: LayoutInflater
    private var mNewsData: List<News>

    init {
        this.mInflater = LayoutInflater.from(context)
        this.mNewsData = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = mInflater.inflate(R.layout.news_item, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val news = mNewsData[position]
        holder.newsDescription.text = news.description
        holder.newsImage.setImageBitmap(BitmapFactory.decodeResource(mInflater.context.resources, news.logoId))
        holder.newsTitle.text = news.title
    }

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var newsImage = itemView.news_image
        var newsTitle = itemView.news_title
        var newsDescription = itemView.news_description

    }

}