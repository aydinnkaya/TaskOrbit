package com.aydinkaya.taskorbit.viewmodel.other

/*
import androidx.lifecycle.ViewModel
import com.aydinkaya.taskorbit.data.entity.ToDoListItem
import java.util.Date
import java.util.UUID
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class NewItemViewModel : ViewModel() {

    private val _title = mutableStateOf("")
    val title: State<String> get() = _title

    private val _dueDate = mutableStateOf(Date())
    val dueDate: State<Date> get() = _dueDate

    private val _showError = mutableStateOf(false)
    val showError: State<Boolean> get() = _showError

    // Function to update title
    fun updateTitle(newTitle: String) {
        _title.value = newTitle
    }

    // Function to update due date
    fun updateDueDate(newDate: Date) {
        _dueDate.value = newDate
    }

    // Function to check if save operation can proceed
    fun canSave(): Boolean {
        if (_title.value.trim().isEmpty()) {
            return false
        }

        // Check if due date is today or later
        val today = Date()
        if (_dueDate.value.before(today)) {
            return false
        }

        return true
    }

    // Function to save new item
    fun save(onSaveComplete: (ToDoListItem) -> Unit) {
        if (!canSave()) {
            _showError.value = true
            return
        }

        // Convert Date to Long (timestamp)
        val dueDateTimestamp = _dueDate.value.time
        val createDateTimestamp = Date().time // Current time as timestamp

        val newItem = ToDoListItem(
            id = UUID.randomUUID().toString(),
            title = _title.value,
            dueDate = dueDateTimestamp, // Store as timestamp
            createDate = createDateTimestamp, // Store current time as timestamp
            isDone = false
        )

        // Call the save completion callback to handle item saving (to local storage or elsewhere)
        onSaveComplete(newItem)

        // Reset the view model state after saving
        _title.value = ""
        _dueDate.value = Date()
        _showError.value = false
    }
}

 */
