open class  Phone (val number: String) {
    fun sendSms( to: String, message: String) {
        println("Send sms to $to: $message")
    }
    open fun call (to: String) {
        println("Call to $to")
    }
}


class Smartphone(number: String) : Phone(number) {
    override fun call (to: String) {
        when {
            to.startsWith("whatsapp:") -> println("Whatsapp call to $to")
            to.startsWith("telegram:") -> println("Telegram call to $to")
            to.startsWith("skype:") -> println("Skype call to $to")
            else -> super.call(to)
        }
    }

}

open class Doc1(
    val tDoc: String
) {
    open fun addPrefix(numDoc: Int, prefixDoc: String){
        println("${tDoc} № $numDoc $prefixDoc")
    }
}

class Spr1(
    tDoc: String
) : Doc1(tDoc) {
    override fun addPrefix(numDoc: Int, prefixDoc: String) {
        super.addPrefix(numDoc, prefixDoc)
    }

}

fun main() {
    whenPublishedPresentation()
    val iphone = Smartphone("+79275XXXXXX")
    iphone.call("whatsapp:+79275YYYYYY")
    iphone.call("+79273ZZZZZZ")
    iphone.sendSms("+79273ZZZZZZ", "Where are you?")

    val doc = Doc1("Поступление")
    doc.addPrefix(755, "d55sfr")

    Spr1("Товар").addPrefix(999,"Dsaw")


}

fun whenPublishedPresentation() {
    val publishedAgo: Long = 60
    val manyDays:Long = 86400
    val twoDays:Long = manyDays * 2
    val fewYearsAgo:Long = (manyDays*356)*2
    val YearsAgo:Long = manyDays*356
    val manyMonths:Long = manyDays*31
    val manyWeeks:Long = manyDays*7


    var verdict = when(publishedAgo) {
        in 0..59 -> "менее минуты назад"
        in 60..90 -> "минуту назад"
        in 90..360 -> " 6 минут назад"
        in 360..3600 -> "час назад"
        in 3600..7200 -> "2 часа назад"
        in 7200..manyDays -> "несколько часов назад"
        in manyDays..twoDays -> "более суток назад"
        in twoDays..manyWeeks -> "более недели назад"
        in manyWeeks..manyMonths -> "более месяца назад"
        in manyMonths..YearsAgo -> "год назад"
        in YearsAgo..fewYearsAgo -> "несколько лет назад"
        else -> "несколько лет назад"
    }

    println(verdict)
}


