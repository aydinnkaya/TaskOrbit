package com.aydinkaya.taskorbit.viewmodel.other

/*
class ToDoListViewModel : ViewModel() {
    // Flow to hold the list of ToDo items
    private val _toDoItems = MutableStateFlow<List<ToDoListItem>>(emptyList())
    val toDoItems: StateFlow<List<ToDoListItem>> = _toDoItems

    // State to track whether the "New Item View" is shown or not
    private val _isAddingItem = mutableStateOf(false)
    val isAddingItem: State<Boolean> get() = _isAddingItem

    // Show or hide the New Item view
    fun showNewItemView(show: Boolean = true) {
        _isAddingItem.value = show
    }

    // Add new item to the list
    fun addItem(title: String, dueDate: Calendar) {
        val newItem = ToDoListItem(
            id = UUID.randomUUID().toString(),
            title = title,
            dueDate = dueDate.timeInMillis,
            createDate = Date().time,
            isDone = false
        )
        // Update the list with the new item
        _toDoItems.value = _toDoItems.value + newItem
    }

    // Toggle the item's completion status
    fun toggleItemDone(item: ToDoListItem) {
        // Update the list by toggling the 'isDone' status of the selected item
        val updatedItem = item.copy(isDone = !item.isDone)
        _toDoItems.value = _toDoItems.value.map {
            if (it.id == updatedItem.id) updatedItem else it
        }
    }

    // Delete an item from the list
    fun deleteItem(item: ToDoListItem) {
        _toDoItems.value = _toDoItems.value.filterNot { it.id == item.id }
    }
}


 */