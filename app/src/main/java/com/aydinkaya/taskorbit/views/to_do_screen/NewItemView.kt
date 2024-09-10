package com.aydinkaya.taskorbit.views.to_do_screen


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.aydinkaya.taskorbit.data.entity.ToDoItem
import java.util.*

@Composable
fun NewItemView(
    newItemPresented: MutableState<Boolean>,
    userId: Int,
    onSave: (ToDoItem) -> Unit
) {
    var description by remember { mutableStateOf("") }
    val calendar = remember { Calendar.getInstance() }
    val context = LocalContext.current

    var date by remember { mutableStateOf(calendar.time) }
    var time by remember { mutableStateOf(String.format("%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE))) } // Seçilen saat

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            date = calendar.time
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    val timePickerDialog = TimePickerDialog(
        context,
        { _, hour, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            time = String.format("%02d:%02d", hour, minute)
        },
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        true
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "New Item",
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { datePickerDialog.show() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Select Date")
        }

        val dateFormatter = android.icu.text.SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        Text("Selected Date: ${dateFormatter.format(date)}", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = { timePickerDialog.show() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Select Time")
        }

        Text("Time: $time", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(32.dp))

        // Kaydetme butonu
        Button(
            onClick = {
                if (description.isNotEmpty()) {
                    val newItem = ToDoItem(
                        id = 0,
                        description = description,
                        date = dateFormatter.format(date),
                        time = time,
                        userId = userId
                    )
                    onSave(newItem)
                    newItemPresented.value = false
                } else {

                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text(text = "Save", color = Color.White)
        }
    }
}
