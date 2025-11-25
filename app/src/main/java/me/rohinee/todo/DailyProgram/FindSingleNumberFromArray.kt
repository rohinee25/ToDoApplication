package me.rohinee.todo.DailyProgram

fun findSingleNumber(arr: IntArray): Int {
    var result = 0
    for (num in arr) {
        result = result xor num
    }
    return result
}
fun main() {
    val arr = intArrayOf(4, 1, 2, 1, 2)
    val singleNumber = findSingleNumber(arr)
    println("The single number is: $singleNumber") // Output: The single number is: 4
}

