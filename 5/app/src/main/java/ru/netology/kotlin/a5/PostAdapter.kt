package ru.netology.kotlin.a5

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_card.view.*
import ru.netology.kotlin.a5.Odb.Post
import ru.netology.kotlin.a5.Odb.list



class PostAdapter(val list: List<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_card, parent, false)
        return PostViewHolder(view)
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

class PostViewHolder(view: View) : RecyclerView.ViewHolder(view){

    fun bind(post: Post){
        with(itemView) {
        textView.text = post.content
    }
    }
}
