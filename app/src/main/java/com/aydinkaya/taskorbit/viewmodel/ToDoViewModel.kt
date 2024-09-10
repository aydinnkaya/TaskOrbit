package com.aydinkaya.taskorbit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aydinkaya.taskorbit.data.entity.ToDoItem
import com.aydinkaya.taskorbit.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(private val toDoRepository: ToDoRepository) : ViewModel() {
    private val _toDos = MutableStateFlow<List<ToDoItem>>(emptyList())
    val toDos: StateFlow<List<ToDoItem>> = _toDos

    fun getToDosForUser(userId: Int) {
        viewModelScope.launch {
            toDoRepository.getToDosForUser(userId).collect { toDoItems ->
                _toDos.value = toDoItems
            }
        }
    }

    fun addToDoItem(userId: Int, description: String, date: String, time: String) {
        viewModelScope.launch {
            val newItem = ToDoItem(
                id = 0,
                userId = userId,
                description = description,
                date = date,
                time = time
            )
            toDoRepository.insertToDoItem(newItem)
            getToDosForUser(userId)
        }
    }

    fun updateToDoItem(updatedItem: ToDoItem) {
        _toDos.value = _toDos.value.map { if (it.id == updatedItem.id) updatedItem else it }
    }

    fun deleteToDoItem(item: ToDoItem) {
        viewModelScope.launch {
            println("Silme işlemi başlıyor: ${item.description}")
            toDoRepository.deleteToDoItem(item)
            getToDosForUser(item.userId)
            println("Silme işlemi tamamlandı.")
        }
    }
    fun searchToDos(userId: Int, query: String) {
        viewModelScope.launch {
            toDoRepository.searchToDos(userId, query).collect { searchResults ->
                _toDos.value = searchResults
            }
        }
    }
}
