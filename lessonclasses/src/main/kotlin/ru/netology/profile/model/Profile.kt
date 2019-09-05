package ru.netology.profile.model


class Avatar(
    val urlPhoto: String,
    val name: String
)

enum class Status {
    BUSY, FREE
}

class Profile(
    val id: Int,
    val login: String,
    val firstName: String,
    val lastName: String,
    var status: Status,
    var avatar: Avatar,
    val fullName: String = firstName + " " + lastName
)

