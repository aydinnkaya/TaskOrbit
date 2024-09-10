package com.aydinkaya.taskorbit.data.datasource

import com.aydinkaya.taskorbit.data.entity.ToDoItem
import com.aydinkaya.taskorbit.room.ToDoDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoDataSource @Inject constructor(private val toDoDao: ToDoDao) {

    suspend fun insertToDoItem(toDoItem: ToDoItem) {
        toDoDao.insertToDoItem(toDoItem)
    }

    suspend fun updateToDoItem(toDoItem: ToDoItem) {
        toDoDao.updateToDoItem(toDoItem)
    }

    suspend fun deleteToDoItem(toDoItem: ToDoItem) {
        toDoDao.deleteToDoItem(toDoItem)
    }

    fun getToDosForUser(userId: Int): Flow<List<ToDoItem>> {
        return toDoDao.getToDosForUser(userId)
    }

    fun searchToDos(userId: Int, query: String): Flow<List<ToDoItem>> {
        return toDoDao.searchToDos(userId, query)
    }
}
