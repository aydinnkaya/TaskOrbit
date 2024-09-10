package com.aydinkaya.taskorbit.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "todo_items")
data class ToDoItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") @NotNull var id: Int = 0,  // Auto-incrementing primary key for todo items

    @ColumnInfo(name = "user_id") @NotNull var userId: Int,  // Foreign key, refers to the User table

    @ColumnInfo(name = "description") @NotNull var description: String,  // Description of the task

    @ColumnInfo(name = "date") @NotNull var date: String,  // Date for the task

    @ColumnInfo(name = "time") @NotNull var time: String  // Time for the task
)
