package me.rohinee.todo.data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import me.rohinee.todo.data.local.ToDo
import me.rohinee.todo.data.local.ToDoDao
import me.rohinee.todo.data.remote.ToDoApiService
import javax.inject.Inject


class ToDoRepository @Inject constructor(
    private val toDoDao: ToDoDao,
    private val apiService: ToDoApiService
){
    val allToDos: Flow<List<ToDo>> = toDoDao.getAllToDo()
    suspend fun refreshTodos(){
        try {
            val remoteTodos = apiService.getToDos()
            toDoDao.upsertAll(remoteTodos)
        }catch (e: Exception)
        {
            Log.e("ToDoRepository", "Error refreshing todos: ${e.message}")
            e.printStackTrace()
        }
    }
}