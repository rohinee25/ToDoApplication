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
}