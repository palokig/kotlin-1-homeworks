package ru.netology.profile

import ru.netology.hiearchy.view.TextView
import ru.netology.hiearchy.view.View
import ru.netology.hiearchy.view.ViewGroup
import ru.netology.profile.model.Avatar
import ru.netology.profile.model.Profile
import ru.netology.profile.model.Status

fun main() {
    val text = TextView("Some Text")
    text.click() // вызывается метод из `View`
    println(text.text) // Some Text
    text.text = "Something bad happened"
    println(text.text) // Something bad happened

    val valueAvatar = Avatar("urlPhotontext", "nameText")
    val valueStatus = Status.BUSY
    val valueProfile = Profile(
        55,
        "test",
        "Иван",
        "Иванов",
        valueStatus,
        valueAvatar
    )

    println(valueProfile.fullName)

    println(valueProfile.status)
    println(valueProfile.avatar.name)
    println(valueProfile.status)



}