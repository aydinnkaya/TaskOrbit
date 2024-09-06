package com.aydinkaya.taskorbit.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.aydinkaya.taskorbit.viewmodel.LoginViewModel
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(viewModel: LoginViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        HeaderView(
            title = "Register",
            subtitle = "Start organizing todos",
            angle = 15f,
            backgroundColor = Color(0xFFF50053)
        )

        Spacer(modifier = Modifier.height(120.dp))


        if (viewModel.errorMessage.value.isNotEmpty()) {
            Text(
                text = viewModel.errorMessage.value,
                color = Color.Red,
                modifier = Modifier.padding(8.dp)
            )
        }


        if (viewModel.loginSuccess.value) {
            Text(
                text = "Login successful!",
                color = Color.Green,
                modifier = Modifier.padding(8.dp)
            )
        }


        OutlinedTextField(
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            label = { Text("Enter your email") },
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
                .padding(vertical = 8.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray.copy(alpha = 0.1f)),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Email,
                autoCorrect = false
            )
        )


        OutlinedTextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            label = { Text("Enter your password") },
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
                .padding(vertical = 8.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray.copy(alpha = 0.1f)),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                autoCorrect = false
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth() .padding(vertical = 2.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = {  }) {
                Text(
                    text = "Forgot Password?",
                    color = Color(0xFF007AFF)
                )
            }
        }

        Button(
            onClick = { },
            modifier = Modifier
                .padding(vertical = 10.dp)
                .width(340.dp)
                .height(44.dp)
                .clip(RoundedCornerShape(20.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF))
        ) {
            Text(
                text = "Log In",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray
        )


        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(text = "New around here?")
            TextButton(
                onClick = { /* Navigate to Register */ },
            ) {
                Text("Create An Account", color = Color(0xFF007AFF))
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginViewPreview() {
    LoginView(viewModel = LoginViewModel())
}
