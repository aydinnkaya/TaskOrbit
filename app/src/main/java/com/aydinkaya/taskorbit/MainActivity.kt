package com.aydinkaya.taskorbit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.aydinkaya.taskorbit.ui.theme.TaskOrbitTheme
import com.aydinkaya.taskorbit.viewmodel.LoginViewModel
import com.aydinkaya.taskorbit.viewmodel.RegisterViewModel
import com.aydinkaya.taskorbit.views.LoginView
import com.aydinkaya.taskorbit.views.RegisterView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskOrbitTheme {
                val viewModel = RegisterViewModel()
                val loginViewModel = LoginViewModel()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        //LoginView(viewModel = loginViewModel)
                        RegisterView(viewModel)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskOrbitTheme {

    }
}