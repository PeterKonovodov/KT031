const val secondsInHour = 3600
const val secondsInMinute = 60
const val hoursInDay = 24
const val secondsInDay = hoursInDay * secondsInHour


fun main() {

    println("Пользователь был в сети ${agoToText(119)}")
    println("Пользователь был в сети ${agoToText(120)}")

//    for (i in 0..50) println("$i ${endHours(i)}")
//    for (i in 0..200) println("$i ${endMinutes(i)}")

}

fun agoToText(seconds: Int): String {
    return when (true) {
        seconds in 0..secondsInMinute -> "только что"
        seconds in secondsInMinute - 1..secondsInHour -> {
            val minutesAgo = seconds / secondsInMinute; "$minutesAgo ${endMinutes(minutesAgo)} назад"
        }
        seconds in secondsInHour + 1..secondsInDay -> {
            val hoursAgo = seconds / secondsInHour; "$hoursAgo ${endHours(hoursAgo)} назад"
        }
        seconds in secondsInDay + 1..secondsInDay * 2 -> "сегодня"
        seconds in secondsInDay * 2 + 1..secondsInDay * 3 -> "вчера"
        seconds > secondsInDay * 3 -> "давно"
        else -> "никогда"
    }
}


fun endHours(hours: Int): String {
    return when (hours % 20) {
        1 -> "час"
        2, 3, 4 -> "часа"
        else -> "часов"
    }
}

fun endMinutes(minutes: Int): String {
    return when (minutes) {
        in 11..14 -> "минут"
        else -> when (minutes % 10) {
            1 -> "минуту"
            in 2..4 -> "минуты"
            else -> "минут"
        }
    }
}