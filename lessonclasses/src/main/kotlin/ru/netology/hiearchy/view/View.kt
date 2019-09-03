package ru.netology.hiearchy.view

open class View{
    open fun click() {
        println("View clicked")
    }
}

open class TextView(
    var text: String
): View() {
    override fun click() {
        super.click()
    }
}

fun main() {
    val text = TextView("Some Text")
    text.click() // вызывается метод из `View`
    println(text.text) // Some Text
    text.text = "Something bad happened"
    println(text.text) // Something bad happened
}
