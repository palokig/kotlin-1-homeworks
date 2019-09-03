package ru.netology.profile.model


class Avatar (
    val urlPhoto: String,
    val name:  String
)

enum class Status{
    ЗАНЯТ, СВОБОДЕН
}

class Profile (
    val id: Int,
    val login: String,
    val firstName: String,
    val lastName: String,
    var status: Status,
    var avatar: Avatar,
    val fullName: String = firstName + " " + lastName
)

fun main() {
    val valueAvatar = Avatar("urlPhotontext","nameText")
    val valueStatus = Status.ЗАНЯТ
    val valueProfile = Profile(55,
        "test",
        "Иван" ,
        "Иванов",
        valueStatus,
        valueAvatar)

    println(valueProfile.fullName)

    println(valueProfile.status)
    println(valueProfile.avatar.name)
    println(valueProfile.status)

}