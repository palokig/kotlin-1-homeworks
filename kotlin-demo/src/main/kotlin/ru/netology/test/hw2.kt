package ru.netology.test

import ru.netology.kotlin.calculateFee

fun main() {
    val growth = 1.8
    val weightPerson = 80
    var index = bodyMassIndex(weightPerson.toFloat(), growth.toFloat())

    var verdict = when(index) {
        in 0F..16.0F -> "Выраженный дефицит массы тела"
        in 16F..18.5F -> "Недостаточная (дефицит) масса тела"
        in 18.5F..24.99F -> "Норма"
        in 24.99F..30.0F -> "Избыточная масса тела (предожирение)"
        in 30.0F..35.0F -> "Ожирение"
        in 35.0F..40.0F -> "Ожирение резкое"
        else -> "Очень резкое ожирение"
    }

        println(verdict)
        //println(index)


    val amount = 200 // стоимость текущей продажи
    val total = 50_001 // сумма предыдущих продаж
    val exclusive = true
    var fee = calculateFee(amount, total)
    println(fee)
}



fun bodyMassIndex( weightPerson: Float, growth: Float): Float {
    return weightPerson/(growth*growth)
}
