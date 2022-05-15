package com.example.besttodo.data.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.besttodo.data.data_base.dao.ToDoDao
import com.example.besttodo.data.models.ToDo

@Database(entities = [ToDo::class], version = 1, exportSchema = false)
abstract class TestDataBase : RoomDatabase() {
    abstract val todoDao: ToDoDao
}