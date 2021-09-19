package com.example.besttodo.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDo(@PrimaryKey @ColumnInfo(name = "name") val name: String)
