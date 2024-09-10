package com.aydinkaya.taskorbit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import com.aydinkaya.taskorbit.viewmodel.ToDoViewModel
import com.aydinkaya.taskorbit.viewmodel.UserViewModel
import com.aydinkaya.taskorbit.views.user_screen.AppNavHost


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val userViewModel: UserViewModel by viewModels()
    val toDoViewModel: ToDoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                AppNavHost(userViewModel = userViewModel, toDoViewModel = toDoViewModel)
        }
    }
}


