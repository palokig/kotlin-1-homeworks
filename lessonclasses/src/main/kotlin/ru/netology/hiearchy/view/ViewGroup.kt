package ru.netology.hiearchy.view

import ru.netology.hiearchy.view.View

class ViewGroup (
    var view: View
) :View() {
    fun addView(view: View) {
        this.view = view
    }
}
