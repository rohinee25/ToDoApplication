package me.rohinee.todo.data.remote


import me.rohinee.todo.data.local.ToDo
import retrofit2.http.GET

interface ToDoApiService {
    @GET("ToDos")
    suspend fun getToDos(): List<ToDo>

}