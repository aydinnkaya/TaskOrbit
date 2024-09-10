package com.aydinkaya.taskorbit.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aydinkaya.taskorbit.data.entity.ToDoItem
import com.aydinkaya.taskorbit.data.entity.User

@Database(entities = [User::class, ToDoItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun toDoDao(): ToDoDao
}
