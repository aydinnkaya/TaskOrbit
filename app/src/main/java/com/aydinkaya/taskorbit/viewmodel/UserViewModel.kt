package com.aydinkaya.taskorbit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aydinkaya.taskorbit.data.entity.User
import com.aydinkaya.taskorbit.data.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _loggedInUser = MutableLiveData<User?>()
    val loggedInUser: LiveData<User?> = _loggedInUser

    private val _registrationSuccess = MutableLiveData<Boolean>()
    val registrationSuccess: LiveData<Boolean> = _registrationSuccess

    fun loginUser(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            val user = userRepository.loginUser(email, password)
            if (user != null) {
                _loggedInUser.postValue(user)
                onResult(true, null)
            } else {
                onResult(false, "Invalid email or password")
            }
        }
    }

    fun registerUser(name: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                userRepository.insertUser(name, email, password)
                _registrationSuccess.postValue(true)
            } catch (e: Exception) {
                _registrationSuccess.postValue(false)
            }
        }
    }

    fun updateUser(userId: Int, name: String, email: String, password: String) {
        viewModelScope.launch {
            userRepository.updateUser(userId, name, email, password)
        }
    }
}
