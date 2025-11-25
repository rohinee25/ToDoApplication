package me.rohinee.todo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [ToDo::class],
    version = 1,
    exportSchema = true
)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao

}