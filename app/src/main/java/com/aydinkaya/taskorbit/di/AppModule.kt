package com.aydinkaya.taskorbit.di

import android.content.Context
import androidx.room.Room
import com.aydinkaya.taskorbit.data.datasource.ToDoDataSource
import com.aydinkaya.taskorbit.data.repo.ToDoRepository
import com.aydinkaya.taskorbit.data.repo.UserRepository
import com.aydinkaya.taskorbit.room.AppDatabase
import com.aydinkaya.taskorbit.room.ToDoDao
import com.aydinkaya.taskorbit.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "todo_database")
            .createFromAsset("todo_database")
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    @Singleton
    fun provideToDoDao(db: AppDatabase): ToDoDao = db.toDoDao()

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }

    @Provides
    @Singleton
    fun provideToDoDataSource(toDoDao: ToDoDao): ToDoDataSource {
        return ToDoDataSource(toDoDao)
    }

    @Provides
    @Singleton
    fun provideToDoRepository(tdds: ToDoDataSource): ToDoRepository {
        return ToDoRepository(tdds)
    }
}
