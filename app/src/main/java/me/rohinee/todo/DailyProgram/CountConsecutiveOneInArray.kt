package me.rohinee.todo.DailyProgram

fun countConsecutiveOnes(arr: IntArray): Int {
    var maxCount = 0
    var currentCount = 0

    for (num in arr) {
        if (num == 1) {
            currentCount++
            maxCount = maxOf(maxCount, currentCount)
        } else {
            currentCount = 0
        }
    }

    return maxCount
}
fun main() {
    val arr = intArrayOf(1, 1, 0, 1, 1, 1, 0, 1, 1)
    val result = countConsecutiveOnes(arr)
    println("Maximum consecutive 1s: $result") // Output: 3
}