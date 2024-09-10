package com.aydinkaya.taskorbit.views.user_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aydinkaya.taskorbit.data.entity.ToDoItem
import com.aydinkaya.taskorbit.viewmodel.ToDoViewModel

@Composable
fun ToDoListScreen(
    toDoViewModel: ToDoViewModel,
    userId: Int, // Kullanıcının ID'si Int olmalı, çünkü veritabanında integer tipinde
    onAddNewToDo: () -> Unit, // Bu fonksiyon geri çağırma fonksiyonu olabilir
) {
    // ViewModel'den toDoItem'lar alınıyor
    val toDos by toDoViewModel.toDos.collectAsState(initial = emptyList())

    // Arama sorgusu ve seçilen to-do için durum değişkenleri
    var searchQuery by remember { mutableStateOf("") }
    var selectedToDo by remember { mutableStateOf<ToDoItem?>(null) }

    Column {
        // Search Bar
        TextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                toDoViewModel.searchToDos(userId, searchQuery)
            },
            label = { Text("Search") }
        )


        // To-Do Item listesi
        LazyColumn {
            items(toDos) { toDoItem ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(toDoItem.description)
                        Text("${toDoItem.date} ${toDoItem.time}")
                    }
                    Row {
                        // Silme butonu
                        IconButton(onClick = {
                            toDoViewModel.deleteToDoItem(toDoItem)
                        }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete")
                        }
                        // Güncelleme butonu
                        IconButton(onClick = {
                            selectedToDo = toDoItem // Güncellenecek item'ı seç
                        }) {
                            Icon(Icons.Default.Edit, contentDescription = "Edit")
                        }
                    }
                }
            }
        }

        // To-Do item ekleme veya güncelleme formu
        var description by remember { mutableStateOf(selectedToDo?.description ?: "") }
        var date by remember { mutableStateOf(selectedToDo?.date ?: "") }
        var time by remember { mutableStateOf(selectedToDo?.time ?: "") }

        TextField(value = description, onValueChange = { description = it }, label = { Text("Description") })
        TextField(value = date, onValueChange = { date = it }, label = { Text("Date") })
        TextField(value = time, onValueChange = { time = it }, label = { Text("Time") })

        // To-Do item ekle/güncelle butonu
        Button(onClick = {
            if (selectedToDo != null) {
                // Var olan ToDoItem güncelleniyor
                toDoViewModel.updateToDoItem(
                    selectedToDo!!.copy(description = description, date = date, time = time)
                )
                selectedToDo = null // Seçimi temizle
            } else {
                // Yeni ToDoItem ekleniyor
                toDoViewModel.addToDoItem(userId, description, date, time)
            }
            // Alanları temizle
            description = ""
            date = ""
            time = ""
        }) {
            Text(if (selectedToDo != null) "Update To-Do" else "Add To-Do")
        }
    }
}
