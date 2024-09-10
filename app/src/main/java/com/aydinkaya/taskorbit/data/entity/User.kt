package com.aydinkaya.taskorbit.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id") @NotNull val userId: Int = 0,  // Auto-incrementing primary key

    @ColumnInfo(name = "user_name") @NotNull val userName: String,  // User name field

    @ColumnInfo(name = "user_email") @NotNull val userEmail: String,  // User email field

    @ColumnInfo(name = "user_password") @NotNull val userPassword: String  // User password field
)


