package me.rohinee.todo.DailyProgram

fun mergeAndSortInPlace(arr1: IntArray, m: Int, arr2: IntArray, n: Int): IntArray {
    // Copy arr2 elements into arr1 starting from index m
    for (i in 0 until n) {
        arr1[m + i] = arr2[i]
    }
    // Sort the first m + n elements of arr1
    arr1.sort(0, m + n)
    return arr1
}

fun main() {
    val arr1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val arr2 = intArrayOf(2, 5, 6)
    val m = 3
    val n = 3
    val mergedSortedArray = mergeAndSortInPlace(arr1, m, arr2, n)
    println(mergedSortedArray.joinToString(", ")) // Output: 1, 2, 2, 3, 5, 6
}