package com.aydinkaya.taskorbit.views.to_do_screen

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.aydinkaya.taskorbit.data.entity.ToDoItem
import java.util.*

@Composable
fun NewItemView(
    newItemPresented: MutableState<Boolean>,
    userId: Int,
    onSave: (ToDoItem) -> Unit
) {
    // Gradyan renkleri
    val gradientColors = listOf(
        Color(0xFFD15B83), // Lime yeşili
        Color(0xFFAB87EB)  // Açık mor
    )

    var description by remember { mutableStateOf("") }
    val calendar = remember { Calendar.getInstance() }
    val context = LocalContext.current

    var date by remember { mutableStateOf(calendar.time) }
    var time by remember {
        mutableStateOf(
            String.format(
                "%02d:%02d",
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE)
            )
        )
    }

    val datePickerDialog =
        createDatePickerDialog(context, calendar, onDateSelected = { selectedDate ->
            date = selectedDate
        })

    val timePickerDialog =
        createTimePickerDialog(context, calendar, onTimeSelected = { selectedTime ->
            time = selectedTime
        })

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

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3
        )

        Spacer(modifier = Modifier.height(32.dp))

        GradientButton(
            text = "Select Date",
            gradientColors = gradientColors,
            onClick = { datePickerDialog.show() }
        )

        val dateFormatter = android.icu.text.SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        RoundedText(
            text = "Selected Date: ${dateFormatter.format(date)}",
            backgroundColor = Color(0xFFF3E5F5),
            textColor = Color(0xFF6200EE)
        )

        Spacer(modifier = Modifier.height(32.dp))

        GradientButton(
            text = "Select Time",
            gradientColors = gradientColors,
            onClick = { timePickerDialog.show() }
        )

        RoundedText(
            text = "Time: $time",
            backgroundColor = Color(0xFFF3E5F5),
            textColor = Color(0xFF6200EE)
        )

        Spacer(modifier = Modifier.height(32.dp))

        GradientButton(
            text = "Save",
            gradientColors = gradientColors,
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
                }
            }
        )
    }
}

fun createDatePickerDialog(
    context: android.content.Context,
    calendar: Calendar,
    onDateSelected: (Date) -> Unit
): DatePickerDialog {
    return DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            onDateSelected(calendar.time)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )
}

fun createTimePickerDialog(
    context: android.content.Context,
    calendar: Calendar,
    onTimeSelected: (String) -> Unit
): TimePickerDialog {
    return TimePickerDialog(
        context,
        { _, hour, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            onTimeSelected(String.format("%02d:%02d", hour, minute))
        },
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        true
    )
}

@Composable
fun GradientButton(
    text: String,
    gradientColors: List<Color>,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(gradientColors)
            ),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Text(text = text, color = Color.White)
    }
}

@Composable
fun RoundedText(
    text: String,
    backgroundColor: Color,
    textColor: Color
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            letterSpacing = 1.5.sp,
            color = textColor
        ),
        modifier = Modifier
            .padding(16.dp)
            .shadow(4.dp, shape = RoundedCornerShape(8.dp))
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
        textAlign = TextAlign.Center
    )
}
