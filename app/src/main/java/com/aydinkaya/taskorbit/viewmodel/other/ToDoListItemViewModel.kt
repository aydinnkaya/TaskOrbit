package com.aydinkaya.taskorbit.viewmodel.other

/*
import androidx.compose.runtime.mutableStateListOf
import com.aydinkaya.taskorbit.data.entity.ToDoListItem

class ToDoListItemViewModel {
    // Local storage for to-do items
    private val items = mutableStateListOf<ToDoListItem>()

    // Initializes the list (could come from some other source, e.g., a database)
    init {
        // Example: Add a few to-do items initially
        items.addAll(
            listOf(
                ToDoListItem(id = "1", title = "Get Milk", dueDate = System.currentTimeMillis(), createDate = System.currentTimeMillis(), isDone = false),
                ToDoListItem(id = "2", title = "Do Homework", dueDate = System.currentTimeMillis(), createDate = System.currentTimeMillis(), isDone = false)
            )
        )
    }

    // Returns the list of items
    fun getItems() = items

    // Toggle the 'isDone' state of the item
    fun toggleIsDone(item: ToDoListItem) {
        val index = items.indexOfFirst { it.id == item.id }
        if (index != -1) {
            val updatedItem = items[index].copy(isDone = !item.isDone)
            items[index] = updatedItem
        }
    }
}

 */