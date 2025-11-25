package me.rohinee.todo.ui.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import me.rohinee.todo.data.ToDoRepository
import me.rohinee.todo.data.local.ToDo
import javax.inject.Inject
import kotlin.random.Random


@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel(){

    val todos: StateFlow<List<ToDo>> =repository.allToDos.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    init{
        viewModelScope.launch {
            repository.refreshTodos()
        }
    }

    fun addTodo(title: String) {
        viewModelScope.launch {
            // Generating a random ID for demo purposes. In a real app, Room can auto-generate IDs.
            // Also assigning a static userId for now.
            val newTodo = ToDo(
                id = Random.nextInt(),
                userId = 1,
                title = title,
                completed = false
            )
            repository.insert(newTodo)
        }
    }
}
