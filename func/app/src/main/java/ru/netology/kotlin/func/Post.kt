package ru.netology.kotlin.func

class Post (
    val id: Long,
    val author: String,
    val content: String,
    val created: Long, // пока строка
    val likedByMe: Boolean = false,
    val numberLiked: Long,
    val postByMe: Boolean = false,
    val numberPost: Long,
    val shareByMe: Boolean = false,
    val numberShare: Long,
    val urlVideoContent:String
) {
    fun copy(post:Post,likedByMe: Boolean) :Post{
        return Post(
            post.id, post.author, post.content, post.created, likedByMe,
            if (likedByMe) post.numberLiked + 1 else post.numberLiked - 1,
            post.postByMe, post.numberPost, post.shareByMe, post.numberShare,
            post.urlVideoContent
        )
    }
}