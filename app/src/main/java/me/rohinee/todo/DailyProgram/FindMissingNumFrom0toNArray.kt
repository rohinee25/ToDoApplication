package me.rohinee.todo.DailyProgram

fun findMissingNumFrom0toNArray(arr: IntArray): Int {
    val n = arr.size
    val expectedSum = n * (n + 1) / 2
    val actualSum = arr.sum()
    return expectedSum - actualSum
}
fun main() {
    val arr = intArrayOf(3, 0, 1)
    val missingNumber = findMissingNumFrom0toNArray(arr)
    println("The missing number is: $missingNumber") // Output: The missing number is: 2
}