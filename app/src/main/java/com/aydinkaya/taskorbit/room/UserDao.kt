package com.aydinkaya.taskorbit.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aydinkaya.taskorbit.data.entity.User
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM users WHERE user_id = :userId")
    suspend fun getUserById(userId: Int): User?

    @Query("SELECT * FROM users WHERE user_email = :email AND user_password = :password")
    suspend fun loginUser(email: String, password: String): User?
}

