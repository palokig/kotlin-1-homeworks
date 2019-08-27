fun main() {
    val amount = 200 // стоимость текущей продажи
    val total = 11_000 // сумма предыдущих продаж
    val exclusive = true
    val fee = calculateFee(amount, total, exclusive)  // exclusive по умолчанию = false
    println(fee) // 40

}

fun calculateFee(amount: Int, total: Int, exclusive: Boolean = false): Int {
    //Если предыдущая сумма продаж от 0 до 1 000, то % составляет 30% от суммы
    //Если предыдущая сумма продаж от 1 001 до 10 000, то % составляет 25% от суммы
    //Если предыдущая сумма продаж от 10 001 до 50 000, то % составляет 20% от суммы
    //Если предыдущая сумма продаж от 50 001, то % составляет 15% от суммы
    var sale = 100
    if (total <= 1_000) {
        sale = 30
    }
    else if (total <= 10_000) {
        sale = 25
    }
    else if (total <= 50_000) {
        sale = 20
    }
    else if (total > 50_000) {
        sale = 15
    }


    if (exclusive == false) {
    return amount / 100 * sale
    }
    else {
        return amount / 100 * (sale-5)
    }
}
