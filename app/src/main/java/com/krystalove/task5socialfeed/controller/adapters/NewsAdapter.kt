package com.krystalove.task5socialfeed.controller.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.krystalove.task5socialfeed.R
import com.krystalove.task5socialfeed.model.Feed
import com.krystalove.task5socialfeed.model.Feed.News

import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(activity: Activity) : AdapterDelegate<List<Feed>>() {

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
        items: List<Feed>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val vh = holder as NewsHolder
        val news = items[position] as News
        vh.likeFrame.setOnClickListener{
            onLikeAction(vh, news)
        }
        Glide.with(mInflater.context)
            .load(news.logoId)
            .into(vh.newsImage)
        vh.newsDescription.text = news.description
        vh.newsTitle.text = news.title
        vh.likeCount.text = ("(${news.likes})")

        val heartID: Int
        when(news.isLiked){
            true -> {
                heartID = R.drawable.heart_icon_red
                vh.likeCount.setTextColor(ContextCompat.getColor(mInflater.context,R.color.Red))
            }
            false ->{
                heartID = R.drawable.heart_icon
                vh.likeCount.setTextColor(ContextCompat.getColor(mInflater.context,R.color.Grey))
            }
        }
        Glide.with(mInflater.context)
            .load(heartID)
            .into(vh.likeIcon)
    }
    private fun onLikeAction(vh: NewsHolder, news: News){
        var heartID = R.drawable.heart_icon_red
        if(news.isLiked){
            vh.likeCount.setTextColor(ContextCompat.getColor(mInflater.context,R.color.Grey))
            news.likes--
            vh.likeCount.text = ("(${news.likes})")
            heartID = R.drawable.heart_icon
            news.isLiked = false
        }else{
            vh.likeCount.setTextColor(ContextCompat.getColor(mInflater.context,R.color.Red))
            news.likes++
            vh.likeCount.text = ("(${news.likes})")
            news.isLiked = true
        }
        Glide.with(mInflater.context)
            .load(heartID)
            .into(vh.likeIcon)
    }

    override fun isForViewType(items: List<Feed>, position: Int): Boolean = items[position] is News

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val newsImage: ImageView = itemView.news_image
        val newsTitle: TextView = itemView.news_title
        val newsDescription: TextView = itemView.news_description
        val likeIcon: ImageView = itemView.like_icon
        var likeCount: TextView = itemView.like_count
        val likeFrame: RelativeLayout = itemView.like_frame
    }
}