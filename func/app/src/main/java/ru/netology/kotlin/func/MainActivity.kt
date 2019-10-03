package ru.netology.kotlin.func

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.kotlin.func.dto.Post
import ru.netology.kotlin.func.dto.list


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(container) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PostAdapter(list)
        }


        /*

        updatePost(post)


        likeBtn.setOnClickListener {

            post = post.copy(
                likedByMe = !post.likedByMe,
                numberLiked = if (!post.likedByMe) post.numberLiked + 1 else post.numberLiked - 1
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

                //val location = Pair(55.75222, 37.61556)
                val lat = post.addressFirst
                val lng = post.addressSecond
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

    fun updatePost(post: Post){
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
        }*/
    }


}



