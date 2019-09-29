package ru.netology.kotlin.func

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var post:Post = Post(1, "Vasya", "тест First post in our network!",
            72100,true,1,true,
            20,true,15,"")

        updatePost(post)


        likeBtn.setOnClickListener {

            post = post.copy(post,
                likedByMe = !post.likedByMe
            )
            updatePost(post)
        }


        youtubeBtn.setOnClickListener{

            val intent = Intent().apply {
                Intent.ACTION_VIEW
                data = Uri.parse(post.urlVideoContent)
            }
            startActivity(intent)
            updatePost(post)
        }

        shareByMeTv.setOnClickListener {

                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT,
                        """
                    ${post.author} (${post.created})
                    ${post.content}
                    """.trimIndent())
                    type = "text/plain"
                }
                startActivity(intent)
                updatePost(post)
            }



        locationBtn.setOnClickListener{

            val intent = Intent().apply {
                Intent.ACTION_VIEW

                val location = Pair(55.75222, 37.61556)
                val lat = location.first
                val lng = location.second
                data = Uri.parse("geo:$lat,$lng")
            }
            startActivity(intent)
            updatePost(post)
        }




    }

     fun favoriteActive() {
        likeBtn.setImageResource(R.drawable.ic_favorite_active_24dp)
        numberLikedTv.setTextColor(Color.RED)
    }

    fun favoriteInactive(){
        likeBtn.setImageResource(R.drawable.ic_favorite_inactive_24dp)
        numberLikedTv.setTextColor(Color.parseColor("#EEEEEE"))
    }

    fun favoriteSetVisibility(numberLiked:Long){
        if (numberLiked == 0.toLong()) {
            numberLikedTv.setVisibility(View.GONE);
        }
        else {
            numberLikedTv.setVisibility(View.VISIBLE);
        }
    }

    fun updatePost(post:Post){
        createdTv.text = whenPublishedPresentation(post.created)
        contentTv.text = post.content
        nameUserTv.text = post.author
        numberLikedTv.text = post.numberLiked.toString()
        // управление favorite
        if (post.likedByMe) {
            favoriteActive()
        }
        else {
            favoriteInactive()
        }


        favoriteSetVisibility(post.numberLiked)



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
        if (post.urlVideoContent == "") {
            youtubeBtn.setVisibility(View.GONE);
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