package com.aydinkaya.taskorbit.views.to_do_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aydinkaya.taskorbit.data.entity.ToDoItem
import com.aydinkaya.taskorbit.viewmodel.ToDoViewModel

@Composable
fun ToDoListItemView(
    toDoViewModel: ToDoViewModel,
    item: ToDoItem
) {
    var selectedToDo by remember { mutableStateOf<ToDoItem?>(null) }

    val gradientColors = listOf(
        Color(0xFFFCE4EC), // Light Pink
        Color(0xFFFFCDD2)  // Slightly darker Pink
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(gradientColors),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            )

            if (item.date.isNotEmpty()) {
                Text(
                    text = formatDate(item.date),
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
                )
            } else {
                Text(
                    text = "No date provided",  // Boş ise varsayılan bir mesaj
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            IconButtonWithAction(
                icon = Icons.Default.Edit,
                contentDescription = "Edit",
                onClick = { selectedToDo = item }
            )

            Spacer(modifier = Modifier.width(8.dp))

            IconButtonWithAction(
                icon = Icons.Default.Delete,
                contentDescription = "Delete",
                onClick = { toDoViewModel.deleteToDoItem(item) }  // Silme işlemi
            )
        }
    }

    if (selectedToDo != null) {
        EditToDoItemForm(
            toDoItem = selectedToDo!!,
            onSave = { updatedItem ->
                toDoViewModel.updateToDoItem(updatedItem)
                selectedToDo = null
            },
            onCancel = { selectedToDo = null }
        )
    }
}

fun formatDate(dateString: String): String {
    return try {
        val sdf = android.icu.text.SimpleDateFormat(
            "MMM dd, yyyy",
            java.util.Locale.getDefault()
        )
        val date = sdf.parse(dateString)
        val outputFormat =
            android.icu.text.SimpleDateFormat("MMM dd, yyyy, h:mm a", java.util.Locale.getDefault())
        outputFormat.format(date!!)
    } catch (e: Exception) {
        "Invalid Date"
    }
}


@Composable
fun EditToDoItemForm(
    toDoItem: ToDoItem,
    onSave: (ToDoItem) -> Unit,
    onCancel: () -> Unit
) {
    var description by remember { mutableStateOf(toDoItem.description) }
    var date by remember { mutableStateOf(toDoItem.date) }
    var time by remember { mutableStateOf(toDoItem.time) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )
        TextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date") }
        )
        TextField(
            value = time,
            onValueChange = { time = it },
            label = { Text("Time") }
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = {
                val updatedItem = toDoItem.copy(description = description, date = date, time = time)
                onSave(updatedItem) // Save the updated item
            }) {
                Text("Save")
            }
            Button(onClick = onCancel) {
                Text("Cancel")
            }
        }
    }
}


@Composable
fun IconButtonWithAction(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .background(Color(0xFF880E4F), shape = RoundedCornerShape(8.dp))
                .padding(4.dp)
        )
    }
}
