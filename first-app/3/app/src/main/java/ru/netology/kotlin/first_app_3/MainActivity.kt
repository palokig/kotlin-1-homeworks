package ru.netology.kotlin.first_app_3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class Post (
    val id: Long,
    val author: String,
    val content: String,
    val created: Long, // пока строка
    var likedByMe: Boolean = false,
    var numberLiked: Long,
    var postByMe: Boolean = false,
    var numberPost: Long,
    var shareByMe: Boolean = false,
    var numberShare: Long
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val post = Post(1, "Vasya", "First post in our network!",
            72100,true,30,true,
            20,true,15)

        createdTv.text = whenPublishedPresentation(post.created)
        contentTv.text = post.content
        nameUserTv.text = post.author

        if (post.likedByMe) {
            likeBtn.setImageResource(R.drawable.ic_favorite_active_24dp)
            numberLikedTv.setTextColor(Color.RED)
        }
        numberLikedTv.text = post.numberLiked.toString()
        if (post.numberLiked == 0.toLong()) {
            numberLikedTv.setVisibility(View.GONE);
        }

        if (post.postByMe) {
            postByMeBtn.setImageResource(R.drawable.ic_chat_bubble_active_24dp)
            numberPostTv.setTextColor(Color.RED)
        }
        numberPostTv.text = post.numberPost.toString()
        if (post.numberPost == 0.toLong()) {
            numberPostTv.setVisibility(View.GONE);
        }


        if (post.shareByMe) {
            shareByMeTv.setImageResource(R.drawable.ic_share_active_24dp)
            numberShareTv.setTextColor(Color.RED)
        }
        numberShareTv.text = post.numberShare.toString()
        if (post.numberShare == 0.toLong()) {
            numberShareTv.setVisibility(View.GONE);
        }
    }
}

fun whenPublishedPresentation(publishedAgo: Long): String {

    val manyDays:Long = 86400
    val twoDays:Long = manyDays * 2
    val fewYearsAgo:Long = (manyDays*356)*2
    val YearsAgo:Long = manyDays*356
    val manyMonths:Long = manyDays*31
    val manyWeeks:Long = manyDays*7


    var verdict = when(publishedAgo) {
        in 0..59 -> "менее минуты назад"
        in 60..90 -> "минуту назад"
        in 90..360 -> " 6 минут назад"
        in 360..3600 -> "час назад"
        in 3600..7200 -> "2 часа назад"
        in 7200..manyDays -> "несколько часов назад"
        in manyDays..twoDays -> "более суток назад"
        in twoDays..manyWeeks -> "более недели назад"
        in manyWeeks..manyMonths -> "более месяца назад"
        in manyMonths..YearsAgo -> "год назад"
        in YearsAgo..fewYearsAgo -> "несколько лет назад"
        else -> "несколько лет назад"
    }

    return verdict
}