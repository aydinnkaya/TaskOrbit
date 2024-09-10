package com.aydinkaya.taskorbit.data.repo

import com.aydinkaya.taskorbit.data.datasource.ToDoDataSource
import com.aydinkaya.taskorbit.data.entity.ToDoItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepository @Inject constructor(private val toDoDataSource: ToDoDataSource) {

    suspend fun insertToDoItem(toDoItem: ToDoItem) {
        toDoDataSource.insertToDoItem(toDoItem)
    }

    suspend fun updateToDoItem(toDoItem: ToDoItem) {
        toDoDataSource.updateToDoItem(toDoItem)
    }

    suspend fun deleteToDoItem(toDoItem: ToDoItem) {
        toDoDataSource.deleteToDoItem(toDoItem)
    }

    fun getToDosForUser(userId: Int): Flow<List<ToDoItem>> {
        return toDoDataSource.getToDosForUser(userId)
    }

    fun searchToDos(userId: Int, query: String): Flow<List<ToDoItem>> {
        return toDoDataSource.searchToDos(userId, query)
    }
}
