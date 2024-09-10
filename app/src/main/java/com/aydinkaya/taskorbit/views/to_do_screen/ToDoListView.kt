package com.aydinkaya.taskorbit.views.to_do_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aydinkaya.taskorbit.viewmodel.ToDoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListView(
    toDoViewModel: ToDoViewModel,
    userId: Int
) {

    val toDos by toDoViewModel.toDos.collectAsState(initial = emptyList())
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TaskOrbit") },
                actions = {
                    IconButton(onClick = {
                        toDoViewModel.searchToDos(userId, searchQuery)
                    }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search To-Do")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(toDos) { item ->
                        ToDoListItemView(
                            toDoViewModel = toDoViewModel,
                            item = item
                        )
                    }
                }

        }
    }
}
