package com.aydinkaya.taskorbit.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aydinkaya.taskorbit.data.entity.ToDoItem
import kotlinx.coroutines.flow.Flow
@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDoItem(toDoItem: ToDoItem)

    @Query("SELECT * FROM todo_items WHERE user_id = :userId")
    fun getToDosForUser(userId: Int): Flow<List<ToDoItem>>

    @Update
    suspend fun updateToDoItem(toDoItem: ToDoItem)

    @Delete
    suspend fun deleteToDoItem(toDoItem: ToDoItem)

    @Query("SELECT * FROM todo_items WHERE description LIKE '%' || :query || '%' AND user_id = :userId")
    fun searchToDos(userId: Int, query: String): Flow<List<ToDoItem>>
}
