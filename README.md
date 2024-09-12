# TaskOrbit 📝

TaskOrbit is a task management app built using **Jetpack Compose**, designed to help users efficiently organize their tasks. Users can create, update, manage, and prioritize tasks, all while keeping track of due dates and times. The app leverages **Room Database** for data persistence, ensuring that tasks are stored locally.

## 📱 App Features

- **Task Management**: Add, edit, and delete tasks. 📝
- **Task Prioritization and Color Coding**: Set task priorities and apply color coding. 🎨
- **Track Task Completion**: Monitor task completion. Completed tasks are automatically moved to the bottom of the list. ✅
- **Task Search Functionality**: Easily search for tasks using the built-in search bar. 🔍
- **User Authentication**: Sign in and sign up functionality to securely access your tasks.
- **Task Scheduling**: Select specific dates and times for tasks to keep everything on track. 🗓️
- **Clean UI**: Built with **Jetpack Compose** for a modern, responsive user interface, enhanced by **Material Design 3** for consistency. 🎨
- **Data Persistence**: Tasks are saved locally using **Room Database**, ensuring your tasks are available offline. 💾
- **MVVM Architecture**: Structured using **Model-View-ViewModel (MVVM)** with **LiveData** and **Hilt** for efficient data management and dependency injection. 📱

---

## Screenshots 📸

| Login Screen       | Register Screen    | Add New Item   |
|--------------------|--------------------|----------------|
| <img width="429" alt="TaskOrbitLogin" src="https://github.com/user-attachments/assets/93d9db05-3a23-45db-b834-2bf48e1beb29"> | <img width="427" alt="Screenshot 2024-09-12 at 15 43 47" src="https://github.com/user-attachments/assets/3eecc4b0-4b67-49e0-89fb-9a80dfc01acb"> |  <img width="429" alt="TaskOrbitRegister" src="https://github.com/user-attachments/assets/e969fdc0-c478-4827-96e6-d670a6a4b835"> |

| Select Date        | Select Time        | Task List       |
|--------------------|--------------------|-----------------|
|  <img width="427" alt="Screenshot 2024-09-12 at 15 08 41" src="https://github.com/user-attachments/assets/9eea35b3-6fb0-445e-872b-02c146497630"> |  <img width="432" alt="Screenshot 2024-09-12 at 15 08 30" src="https://github.com/user-attachments/assets/a5349704-9807-4694-8c79-9e727ef6ad32"> |<img width="433" alt="Screenshot 2024-09-12 at 16 17 11" src="https://github.com/user-attachments/assets/a0e51e8a-6994-4cbf-abfa-8adcb1ebf8de"> |

---

## 🚀 Technologies Used

- **Jetpack Compose**: Modern UI toolkit for building native Android interfaces.
- **Material Design 3**: For a consistent and intuitive user interface.
- **MVVM Architecture**: Model-View-ViewModel pattern for clean separation of concerns.
- **Room Database**: Local data storage using SQLite, enabling offline persistence.
- **Hilt**: Dependency injection framework that simplifies the injection process.
- **LiveData**: Lifecycle-aware components that automatically update the UI when data changes.
- **Kotlin Coroutines**: For managing background tasks and concurrency.
- **Gson**: A library for converting Java objects to JSON and vice versa.
- **Navigation Compose**: For seamless navigation between composables.

---

## Installation and Setup 🚀

Follow these steps to set up and run the project on your machine:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/TaskOrbit.git
   ```
2. **Open the project in Android Studio**:
   Use **Android Studio** to open and run the project.
3. **Install dependencies**:
   Inside the project directory, install the required dependencies by running:
   ```bash
   ./gradlew installDebug
   ```
4. **Run the project**:
   Connect an emulator or physical device, and run the project from Android Studio.

### Prerequisites

Ensure you have the following tools installed:

- [Android Studio](https://developer.android.com/studio)
- Latest Android SDK and an Emulator or physical device for testing


---


## Database Schema 🗂️

The app uses **Room Database** for local data storage. Below is the schema structure as displayed in the database:

### **User Table**:

| Column Name   | Type    | Notes          |
|---------------|---------|----------------|
| `user_id`     | INTEGER | Primary Key    |
| `user_name`   | TEXT    | User's name    |
| `user_email`  | TEXT    | Unique         |
| `user_password` | TEXT  | User's password|

### **ToDoItem Table**:

| Column Name   | Type    | Notes                    |
|---------------|---------|--------------------------|
| `id`          | INTEGER | Primary Key              |
| `user_id`     | INTEGER | Foreign Key from User    |
| `description` | TEXT    | Description of the task  |
| `date`        | TEXT    | Due date for the task    |
| `time`        | TEXT    | Due time for the task    |

This schema shows the relationship between **User** and **ToDoItem** tables, where the `user_id` in the **ToDoItem** table is a foreign key referring to the `user_id` in the **User** table.


---



## How to Use the App 📲

1. **Sign Up**: Create a new account by entering your name, email, and password.
2. **Login**: Use your credentials to log in to the app.
3. **Create Tasks**: Add tasks by tapping the `+` button and providing a description, priority, date, and time.
4. **Manage Tasks**: View, edit, or delete tasks from the task list. Use the search bar to find specific tasks.
5. **Complete Tasks**: Mark tasks as completed, and they will automatically move to the bottom of the list.

---

## Contributing 🤝

We welcome contributions! To contribute, follow these steps:

1. Fork the repository.
2. Create a new feature branch: `git checkout -b feature-branch-name`
3. Make your changes and commit: `git commit -m 'Description of feature'`
4. Push to your branch: `git push origin feature-branch-name`
5. Open a pull request.



