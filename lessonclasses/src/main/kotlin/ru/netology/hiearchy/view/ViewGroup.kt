package ru.netology.hiearchy.view

import ru.netology.hiearchy.view.View

class ViewGroup (): View() {
    override fun click() {
        super.click()
    }
    fun addView() {  // не уверен что я правильно сделал
        View().click()
    }
}

fun main() {
    ViewGroup().addView()
}