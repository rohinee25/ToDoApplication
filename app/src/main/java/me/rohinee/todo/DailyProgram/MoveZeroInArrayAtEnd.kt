package me.rohinee.todo.DailyProgram

fun moveZerosToEnd(arr: IntArray): IntArray {
    var count = 0 // Count of non-zero elements

    // Traverse the array. If element is non-zero, then
    // replace the element at index 'count' and increment 'count'
    for (i in arr.indices) {
        if (arr[i] != 0) {
            arr[count] = arr[i]
            count++
        }
    }

    // Now all non-zero elements have been shifted to
    // front and 'count' is set as index of first 0.
    // Make all elements 0 from count to end.
    while (count < arr.size) {
        arr[count] = 0
        count++
    }

    return arr
}
fun main() {
    val arr = intArrayOf(0, 1, 0,7,0,0,0,1, 3, 12)
    val result = moveZerosToEnd(arr)
    println(result.joinToString(", ")) // Output: 1, 3, 12, 0, 0
}