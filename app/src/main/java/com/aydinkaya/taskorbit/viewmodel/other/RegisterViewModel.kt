package com.aydinkaya.taskorbit.viewmodel.other

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var errorMessage by mutableStateOf("")

    fun register() {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            errorMessage = "Please fill in all fields"
        } else {
            errorMessage = ""
        }
    }
}