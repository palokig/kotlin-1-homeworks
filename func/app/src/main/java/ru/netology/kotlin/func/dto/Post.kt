package ru.netology.kotlin.func.dto

import ru.netology.kotlin.func.PostType

data class Post (
    val id: Long,
    val author: String,
    val content: String,
    val created: Long, // пока строка
    var likedByMe: Boolean = false,
    var numberLiked: Long,
    val postByMe: Boolean = false,
    val numberPost: Long,
    val shareByMe: Boolean = false,
    val numberShare: Long,
    val urlVideoContent:String,
    val addressFirst:String? = null,
    val addressSecond:String? = null,
    val type: PostType = PostType.POST
)

val list = listOf(
     Post(
        1, "Vasya", "тест First post in our network!",
72100, true, 1, true,
20, true, 15, "", "55.753061", "37.613854", PostType.EVENT
),
    Post(
        1, "Vasya", "тест First post in our network!",
        72100, true, 1, true,
        20, true, 15, "", "55.753061", "37.613854", PostType.EVENT
    ),
    Post(
        1, "Vasya", "тест First post in our network!",
        72100, true, 1, true,
        20, true, 15, "", "55.753061", "37.613854", PostType.EVENT
    ),
    Post(
        1, "Vasya", "тест First post in our network!",
        72100, true, 1, true,
        20, true, 15, "", "55.753061", "37.613854", PostType.EVENT
    ),
    Post(
        1, "Vasya", "тест First post in our network!",
        72100, true, 1, true,
        20, true, 15, "", "55.753061", "37.613854", PostType.EVENT
    ),
    Post(
        1, "Vasya", "тест First post in our network!",
        72100, true, 1, true,
        20, true, 15, "", "55.753061", "37.613854", PostType.EVENT
    ),
    Post(
        1, "Vasya", "тест First post in our network!",
        72100, true, 1, true,
        20, true, 15, "", "55.753061", "37.613854", PostType.EVENT
    )

)

