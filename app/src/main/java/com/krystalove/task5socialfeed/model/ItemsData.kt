package com.krystalove.task5socialfeed.model

import com.krystalove.task5socialfeed.R

object ItemsData {

    val news by lazy {
        listOf(
            News(
                R.drawable.news_1,
                "Lego",
                "Chevrolet собрала полноразмерную версию своего пикапа из LEGO"
            ),
            News(
                R.drawable.news_2,
                "Spider-Man: Far From Home",
                "Трейлер \"Человек-Паук: Вдали от дома\" установил рекорд просмотров"
            ),
            News(
                R.drawable.news_3,
                "Nasa",
                "Новые анимации NASA демонстрируют скорость света в космосе"
            ),
            News(
                R.drawable.news_4,
                "Windows 10 Mobile",
                "Microsoft прекратит поддержку Windows 10 Mobile в декабре"
            ),
            News(
                R.drawable.news_5,
                "Pixar",
                "Режиссер \"Истории игрушек 3\" и \"Тайны Коко\" покинул студию Pixar"
            ),
            News(
                R.drawable.news_6,
                "NES",
                "Картридж The Legend of Zelda продали за \$3360 на аукционе"
            ),
            News(
                R.drawable.news_7,
                "RTX",
                "Мод позволяет запустить трассировку в Quake 2 на видеокартах Nvidia"
            )
        )
    }
    val notification by lazy {
        listOf(
            Notification(
                R.drawable.notification_1,
                "Gabe Newell",
                "Welcome to The International!"
            ),
            Notification(
                R.drawable.notification_1,
                "Gabe Newell",
                "Welcome to The International!"
            ),
            Notification(
                R.drawable.notification_1,
                "Gabe Newell",
                "Welcome to The International!"
            ),
            Notification(
                R.drawable.notification_1,
                "Gabe Newell",
                "Welcome to The International!"
            ),
            Notification(
                R.drawable.notification_1,
                "Gabe Newell",
                "Welcome to The International!"
            ),
            Notification(
                R.drawable.notification_1,
                "Gabe Newell",
                "Welcome to The International!"
            )
        )
    }
    val allItems = news + notification
}