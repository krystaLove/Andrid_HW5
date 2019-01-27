package com.krystalove.task5socialfeed.model

sealed class Feed {
    data class News(
        val logoId: Int? = null,
        val title: String,
        val description: String,
        var isLiked: Boolean = false,
        val imageUri: String? = null,
        var likes: Int = (0..1000).random()
    ) : Feed()

    data class Notification(
        val logoId: Int,
        val title: String,
        val notification: String
    ) : Feed()
}