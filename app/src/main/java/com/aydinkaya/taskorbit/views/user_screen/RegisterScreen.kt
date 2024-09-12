package com.aydinkaya.taskorbit.views.user_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.aydinkaya.taskorbit.viewmodel.UserViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.aydinkaya.taskorbit.views.to_do_screen.HeaderView

@Composable
fun RegisterScreen(userViewModel: UserViewModel, navController: (String) -> Unit) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val lifecycleOwner = LocalLifecycleOwner.current

    var registrationSuccess by remember { mutableStateOf(false) }

    DisposableEffect(lifecycleOwner) {
        val observer = { success: Boolean ->
            registrationSuccess = success
        }
        userViewModel.registrationSuccess.observe(lifecycleOwner, observer)
        onDispose {
            userViewModel.registrationSuccess.removeObserver(observer)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderView(
            title = "Register",
            subtitle = "Start organizing todos",
            angle = -15f,
            backgroundColor = Color(0xFFFFA500) // Orange color
        )



        Spacer(modifier = Modifier.height(120.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray.copy(alpha = 0.1f))
        ) {
            OutlinedTextField(
                value =name,
                onValueChange = { name = it },
                label = { Text("Full Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .background(Color.Gray.copy(alpha = 0.1f)),
                shape = RoundedCornerShape(20.dp),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    //focusedTextColor = Color.Black,
                    //unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Words,
                    // autoCorrect = false
                )
            )
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray.copy(alpha = 0.1f))
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = {email = it },
                label = { Text("Enter your email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .background(Color.Gray.copy(alpha = 0.1f))
                    .clip(RoundedCornerShape(10.dp)),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    //  focusedTextColor = Color.Black,
                    //  unfocusedTextColor = Color.Gray,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.None,
                    //  autoCorrect = false,
                    keyboardType = KeyboardType.Email
                )
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray.copy(alpha = 0.1f))
        ) {
            // Password SecureField
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter your password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .background(Color.Gray.copy(alpha = 0.1f)) // Gray background
                    .clip(RoundedCornerShape(10.dp)), // Corner radius
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    //  focusedTextColor = Color.Black,
                    // unfocusedTextColor = Color.Gray,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    //autoCorrect = false,
                    keyboardType = KeyboardType.Password
                )
            )


        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray.copy(alpha = 0.1f))
        ) {
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .background(Color.Gray.copy(alpha = 0.1f)) // Gray background
                    .clip(RoundedCornerShape(10.dp)), // Corner radius
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    //  focusedTextColor = Color.Black,
                    // unfocusedTextColor = Color.Gray,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    //autoCorrect = false,
                    keyboardType = KeyboardType.Password
                )
            )
        }


        Button(
            onClick = {
                if (password == confirmPassword) {
                    userViewModel.registerUser(name, email, password)
                }
            },
            modifier = Modifier
                .padding(8.dp)
                .width(340.dp)
                .height(44.dp)
                .clip(RoundedCornerShape(20.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF55D65A))
        ) {
            Text(
                text = "Register",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }

    if (registrationSuccess) {
        LaunchedEffect(Unit) {
            navController("login")
        }
    }
}
