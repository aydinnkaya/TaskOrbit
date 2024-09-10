package com.aydinkaya.taskorbit.views.to_do_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aydinkaya.taskorbit.viewmodel.ToDoViewModel

@Composable
fun AddToDoItemScreen(
    toDoViewModel: ToDoViewModel,
    userId: Int,
    onToDoAdded: () -> Unit
) {
    var description by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

    Column {
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date (YYYY-MM-DD)") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = time,
            onValueChange = { time = it },
            label = { Text("Time (HH:MM)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (description.isNotEmpty() && date.isNotEmpty() && time.isNotEmpty()) {
                    toDoViewModel.addToDoItem(userId, description, date, time)
                    onToDoAdded()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add To-Do Item")
        }
    }
}
