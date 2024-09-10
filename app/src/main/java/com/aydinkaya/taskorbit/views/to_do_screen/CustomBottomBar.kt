package com.aydinkaya.taskorbit.views.to_do_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aydinkaya.taskorbit.viewmodel.ToDoViewModel

@Composable
fun CustomBottomBar(
    toDoViewModel: ToDoViewModel,
    userId: Int
) {
    var currentScreen by remember { mutableStateOf("todoList") }

    val gradientColors = listOf(
        Color(0xFFF80254),
        Color(0xFF673AB7)
    )

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(80.dp)
                    .background(Brush.horizontalGradient(gradientColors)),
                containerColor = Color.Transparent,
                tonalElevation = 30.dp
            ) {

                IconButton(onClick = {
                    currentScreen = "todoList"
                }) {
                    Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.White)
                }

                Spacer(Modifier.weight(1f, true))

                FloatingActionButton(
                    onClick = {
                        currentScreen = "addNewItem"  // Yeni item ekleme ekranına geçiş
                    },
                    containerColor = Color(0xFFF80254),
                    contentColor = Color.White,
                    modifier = Modifier.size(64.dp),
                    shape = CircleShape
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }

                Spacer(Modifier.weight(1f, true))

                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Person, contentDescription = "Profile", tint = Color.White)
                }
            }
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                when (currentScreen) {
                    "todoList" -> {
                        ToDoListView(
                            toDoViewModel = toDoViewModel,
                            userId = userId
                        )
                    }
                    "addNewItem" -> {
                        NewItemView(
                            userId = userId,
                            newItemPresented = remember { mutableStateOf(true) },
                            onSave = { newItem ->
                                toDoViewModel.addToDoItem(
                                    userId = userId,
                                    description = newItem.description,
                                    date = newItem.date,
                                    time = newItem.time
                                )
                                currentScreen = "todoList"
                            }
                        )
                    }
                    else -> {
                        Text("Home Screen Content", color = Color.White)
                    }
                }
            }
        }
    )
}

