package me.rohinee.todo.DailyProgram

fun FindMinMaxFromArr(){
    val arr = arrayOf(3, 5, 1, 8, 2, -4, 7)
    var min = arr[0]
    var max = arr[0]

    for (num in arr) {
        if (num < min) {
            min = num
        }
        if (num > max) {
            max = num
        }
    }

    println("Minimum value: $min")
    println("Maximum value: $max")
}
fun main() {
    FindMinMaxFromArr()
}