package com.aydinkaya.taskorbit.viewmodel.other

import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var email = mutableStateOf("")

    var password = mutableStateOf("")

    var errorMessage = mutableStateOf("")
        private set

    var loginSuccess = mutableStateOf(false)
        private set

    fun onEmailChange(newEmail: String) {
        email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    fun login() {
        if (!validate()) {
            return
        }

        val validEmail = "test@example.com"
        val validPassword = "password123"

        if (email.value == validEmail && password.value == validPassword) {
            loginSuccess.value = true
            errorMessage.value = ""
        } else {
            loginSuccess.value = false
            errorMessage.value = "Invalid email or password."
        }
    }


    private fun validate(): Boolean {
        errorMessage.value = ""

        if (email.value.trim().isEmpty() || password.value.trim().isEmpty()) {
            errorMessage.value = "Please fill in all fields."
            return false
        }

        if (!email.value.contains("@") || !email.value.contains(".")) {
            errorMessage.value = "Please enter a valid email."
            return false
        }

        return true
    }
}
