package me.rohinee.todo.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Update
    suspend fun upsertAll(todos: List<ToDo>)

    @Query("select * from todos")
    fun getAllToDo(): Flow<List<ToDo>>
}
