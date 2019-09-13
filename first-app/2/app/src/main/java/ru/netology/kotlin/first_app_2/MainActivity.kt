package ru.netology.kotlin.first_app_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class Post (
    val id: Long,
    val author: String,
    val content: String,
    val created: String, // пока строка
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
            "20 august 2019",true,30,true,
            20,true,15)
        createdTv.text = post.created
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
