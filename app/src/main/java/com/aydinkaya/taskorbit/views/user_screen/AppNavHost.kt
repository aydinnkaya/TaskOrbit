package com.aydinkaya.taskorbit.views.user_screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aydinkaya.taskorbit.viewmodel.ToDoViewModel
import com.aydinkaya.taskorbit.viewmodel.UserViewModel
import com.aydinkaya.taskorbit.views.to_do_screen.AddToDoItemScreen
import com.aydinkaya.taskorbit.views.to_do_screen.CustomBottomBar

@Composable
fun AppNavHost(
    userViewModel: UserViewModel,
    toDoViewModel: ToDoViewModel
) {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        // Login Screen Route
        composable("login") {
            LoginScreen(userViewModel = userViewModel, onLoginSuccess = { user ->
                navController.navigate("todoList/${user.userId}") {
                    popUpTo("login") { inclusive = true }
                }
            }, navController = navController)
        }

        composable("register") {
            RegisterScreen(userViewModel = userViewModel) {
                // Kayıt başarılı olunca login ekranına yönlendirme yap
                navController.navigate("login") {
                    popUpTo("register") { inclusive = true }
                }
            }
        }

        composable("todoList/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toIntOrNull() ?: -1
            if (userId != -1) {
                CustomBottomBar(
                    toDoViewModel = toDoViewModel,
                    userId = userId,
                    )
            }
        }

        composable("addToDo/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toIntOrNull() ?: -1
            if (userId != -1) {
                AddToDoItemScreen(
                    toDoViewModel = toDoViewModel,
                    userId = userId,
                    onToDoAdded = {
                        navController.popBackStack("todoList/$userId", inclusive = false)
                    }
                )
            }
        }
    }
}
