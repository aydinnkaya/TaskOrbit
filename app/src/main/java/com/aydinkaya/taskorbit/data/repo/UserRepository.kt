package com.aydinkaya.taskorbit.data.repo

import com.aydinkaya.taskorbit.data.entity.User
import com.aydinkaya.taskorbit.room.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun insertUser(name: String, email: String, password: String) {
        val user = User(0, name, email, password)
        userDao.insertUser(user)
    }

    suspend fun updateUser(userId: Int, name: String, email: String, password: String) {
        val user = User(userId, name, email, password)
        userDao.updateUser(user)
    }


    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun getUserById(userId: Int): User? {
        return userDao.getUserById(userId)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}
