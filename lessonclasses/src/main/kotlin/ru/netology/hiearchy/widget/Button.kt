package ru.netology.hiearchy.widget

import ru.netology.hiearchy.view.TextView

class Button (clickMe :String): TextView(clickMe
) {
    override fun click() {
           super.click()
        }

}

fun main() {
    val button = Button("Click me")
    button.click() // вызывается метод из `View`
    println(button.text) // Click me
    button.text = "Don't click me"
    println(button.text) // Don't click me
}