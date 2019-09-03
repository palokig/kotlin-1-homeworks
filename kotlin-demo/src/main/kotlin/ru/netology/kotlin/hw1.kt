package ru.netology.kotlin

fun main() {
    val amount = 200 // стоимость текущей продажи
    val total = 50_001 // сумма предыдущих продаж
    val exclusive = true
    var fee = calculateFee(amount, total)  // exclusive по умолчанию = false
    println(fee) // 40

}

fun calculateFee(amount: Int, total: Int, exclusive: Boolean = false): Int {
    // вычитал в документации что так можно
  /*  var sale = when(total) {
        in 0..1_000 -> 30
        in 1_000..10_000 -> 25
        in 10_000..50_000 -> 20
        else -> 15
    }

   */

    var sale = when {
        compareSales(total, 1_000) -> 30
        compareSales(total, 10_000) -> 25
        compareSales(total, 50_000) -> 20
        else -> 15
    }

    if (exclusive == false) {
        return amount / 100 * sale
    }
    else {
        return amount / 100 * (sale-5)
    }
}
fun compareSales(total: Int , numberToCompare: Int): Boolean {
    if (total <= numberToCompare) {
        return true
    }
    else {
        return false
    }
}
