package com.aydinkaya.taskorbit.data.datasource

import com.aydinkaya.taskorbit.data.entity.User
import com.aydinkaya.taskorbit.room.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserDataSource @Inject constructor(private val userDao: UserDao) {

    suspend fun insertUser(userName: String, userEmail: String, userPassword: String) = withContext(Dispatchers.IO) {
        val newUser = User(0, userName, userEmail, userPassword)
        userDao.insertUser(newUser)
    }

    suspend fun updateUser(userId: Int, userName: String, userEmail: String, userPassword: String) = withContext(Dispatchers.IO) {
        val updatedUser = User(userId, userName, userEmail, userPassword)
        userDao.updateUser(updatedUser)
    }

    suspend fun deleteUser(userId: Int) = withContext(Dispatchers.IO) {
        val userToDelete = User(userId, "", "", "")
        userDao.deleteUser(userToDelete)
    }

    suspend fun getUserById(userId: Int): User? = withContext(Dispatchers.IO) {
        userDao.getUserById(userId)
    }

    suspend fun loginUser(email: String, password: String): User? = withContext(Dispatchers.IO) {
        userDao.loginUser(email, password)
    }
}
