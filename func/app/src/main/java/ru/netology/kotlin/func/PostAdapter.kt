package ru.netology.kotlin.func

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_card.view.*
import ru.netology.kotlin.func.dto.Post


class PostAdapter(val list: List<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_card, parent, false)
        return PostViewHolder(this,view)
    }
    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder as PostViewHolder){
            bind(list[position])



        }

    }
}

class PostViewHolder(val adapter: PostAdapter, view: View) : RecyclerView.ViewHolder(view) {
    init {
       with(itemView) {



            likeBtn.setOnClickListener {

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    val item = adapter.list[adapterPosition]

                    item.likedByMe = !item.likedByMe
                    item.numberLiked = if (item.likedByMe) item.numberLiked + 1 else item.numberLiked - 1
                    adapter.notifyItemChanged(adapterPosition)


                }

            }


            youtubeBtn.setOnClickListener{
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    val item = adapter.list[adapterPosition]
                    val intent = Intent().apply {
                        Intent.ACTION_VIEW
                        data = Uri.parse(item.urlVideoContent)
                    }
                    itemView.context.startActivity(intent)
                }

            }

            shareByMeTv.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    val item = adapter.list[adapterPosition]
                    val intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(
                            Intent.EXTRA_TEXT,
                            """
                    ${item.author} (${item.created})
                    ${item.content}
                    """.trimIndent()
                        )
                        type = "text/plain"
                    }
                    itemView.context.startActivity(intent)
                }

            }

            locationBtn.setOnClickListener{
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    val item = adapter.list[adapterPosition]
                    val intent = Intent().apply {
                        Intent.ACTION_VIEW

                        //val location = Pair(55.75222, 37.61556)
                        val lat = item.addressFirst
                        val lng = item.addressSecond
                        data = Uri.parse("geo:$lat,$lng")
                    }
                    itemView.context.startActivity(intent)
                }

            }
        }

    }

    fun bind(post: Post) {
        with(itemView) {


            createdTv.text = whenPublishedPresentation(post.created)
            contentTv.text = post.content
            nameUserTv.text = post.author
            numberLikedTv.text = post.numberLiked.toString()

            if (post.likedByMe) {
                likeBtn.setImageResource(R.drawable.ic_favorite_active_24dp)
                numberLikedTv.setTextColor(Color.RED)
            } else {
                likeBtn.setImageResource(R.drawable.ic_favorite_inactive_24dp)
                numberLikedTv.setTextColor(Color.parseColor("#EEEEEE"))
            }


            if (post.numberLiked == 0.toLong()) {
                numberLikedTv.setVisibility(View.GONE);
            } else {
                numberLikedTv.setVisibility(View.VISIBLE);
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
            if (post.urlVideoContent == "") {
                youtubeBtn.setVisibility(View.GONE);
            }



        }


    }


}