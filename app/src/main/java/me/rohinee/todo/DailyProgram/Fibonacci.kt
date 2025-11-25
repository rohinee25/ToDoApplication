package me.rohinee.todo.DailyProgram

fun main() {
    val fibonacci = generateSequence(0 to 1) { it.second to it.first + it.second }
        .map { it.first }
        .take(10)
        .toList()
    print(fibonacci)
}