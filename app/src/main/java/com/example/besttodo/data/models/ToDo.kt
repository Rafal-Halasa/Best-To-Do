package com.example.besttodo.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "todo_table")
data class ToDo(@PrimaryKey @ColumnInfo(name = "name") var name: String, @ColumnInfo(name = "done") val done: Boolean = false) :
    Serializable
